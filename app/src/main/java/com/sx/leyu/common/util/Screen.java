package com.sx.leyu.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/3/18.
 */
public class Screen {

    private Context context;

    public static int baseX = 320;
    public static int baseY = 480;

    private float usefulX;
    private float usefulY;

    private static Screen screen;

    Screen(Context context){

        this.context = context;
        initScreenUsefulXY();

        saveScreenInfo();

    }

    private void initScreenUsefulXY(){
        WindowManager windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);

        DisplayMetrics metrics = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(metrics);

        usefulX = metrics.widthPixels;//屏幕宽

        int height = metrics.heightPixels;//不包含虚拟按键

        usefulY = height - getStatusBarHeight();//去掉状态栏的高

    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void saveScreenInfo(){
        SharedPreferences preferences = context.getSharedPreferences("screen",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        float x1 = usefulX / baseX;
        float y1 = usefulY / baseY;

        for (int x=0;x<baseX;x++){
            editor.putFloat("x"+(x+1),x1*(x+1));
        }

        for (int y=0;y<baseY;y++){
            editor.putFloat("y"+(y+1),y1*(y+1));
        }
        editor.commit();
    }

    public static Screen getInstance(Context context){
        if(screen == null){
            screen = new Screen(context);
        }
        return screen;
    }


    public static float getRealX(Context context,int x){

        Screen screen = getInstance(context);

        return screen.getXfromShared(x);
    }
    public static float getRealY(Context context,int x){

        Screen screen = getInstance(context);

        return screen.getYfromShared(x);
    }


    private float getXfromShared(int x){

        SharedPreferences preferences = context.getSharedPreferences("screen",context.MODE_PRIVATE);

        float realX = preferences.getFloat("x"+x,0);

        return realX;
    }

    private float getYfromShared(int x){

        SharedPreferences preferences = context.getSharedPreferences("screen",context.MODE_PRIVATE);

        float realY = preferences.getFloat("y"+x,0);

        return realY;
    }


    /**
     *
     * 获得屏幕的真实宽高，包括了虚拟键跟状态栏的高度
     *
     */
    private void getRealXY(){

        WindowManager windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);

        Display display = windowManager.getDefaultDisplay();

        DisplayMetrics dm = new DisplayMetrics();
        try
        {
            Class f = Class.forName("android.view.Display");
            Method method = f.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);

            float width = dm.widthPixels;// 得到真实宽度
            float height = dm.heightPixels;// 得到真实全部高度

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

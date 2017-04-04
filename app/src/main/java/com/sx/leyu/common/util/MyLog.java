package com.sx.leyu.common.util;

import android.util.Log;

/**
 * Created by Administrator on 2017/3/18.
 */
public class MyLog {

    private static boolean deBug = true;

    public static void e(String str){

        if(deBug){
            if(str == null){
                str = "null";
            }

            Log.e("--------",str);
        }
    }
}

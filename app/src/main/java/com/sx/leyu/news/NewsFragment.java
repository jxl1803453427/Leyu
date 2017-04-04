package com.sx.leyu.news;

import android.view.View;
import android.view.ViewGroup;

import com.sx.leyu.R;
import com.sx.leyu.common.ui.BaseFragment;
import com.sx.leyu.common.util.Screen;

/**
 * Created by Administrator on 2017/3/16.
 */
public class NewsFragment extends BaseFragment{
    @Override
    protected void getViews() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initData() {

        View view = parent.findViewById(R.id.view);

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

        layoutParams.width = (int) Screen.getRealX(getContext(),160);
        layoutParams.height = (int) Screen.getRealY(getContext(),240);

        view.setLayoutParams(layoutParams);


    }

    @Override
    protected void bindViewEvent() {

    }

    @Override
    protected void lazyLoad() {

    }
}

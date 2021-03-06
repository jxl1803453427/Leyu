package com.sx.leyu.common.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/3/15.
 */
public abstract class BaseFragment extends Fragment{
    protected View parent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        parent = inflater.inflate(getLayout(),container,false);

        getViews();
        initData();
        bindViewEvent();
        lazyLoad();

        return parent;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    protected abstract void getViews();
    protected abstract int getLayout();
    protected abstract void initData();
    protected abstract void bindViewEvent();
    protected abstract void lazyLoad();
}

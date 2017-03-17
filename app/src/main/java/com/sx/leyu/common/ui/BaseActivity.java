package com.sx.leyu.common.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sx.leyu.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        getViews();
        initData();
        bindViewEvent();
        loadData();

    }
    protected abstract int getLayout();
    protected abstract void getViews();
    protected abstract void initData();

    protected abstract void bindViewEvent();

    protected abstract void loadData();
}

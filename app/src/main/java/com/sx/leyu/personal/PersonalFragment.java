package com.sx.leyu.personal;

import android.content.Intent;
import android.view.View;

import com.sx.leyu.R;
import com.sx.leyu.TestActivity;
import com.sx.leyu.common.ui.BaseFragment;

/**
 * Created by Administrator on 2017/3/15.
 */
public class PersonalFragment extends BaseFragment{
    @Override
    protected void getViews() {
        parent.findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TestActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindViewEvent() {

    }

    @Override
    protected void lazyLoad() {

    }
}

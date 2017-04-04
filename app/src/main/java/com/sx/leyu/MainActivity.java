package com.sx.leyu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.sx.leyu.R;
import com.sx.leyu.common.ui.BaseActivity;
import com.sx.leyu.news.NewsFragment;
import com.sx.leyu.joker.JokerFragment;
import com.sx.leyu.personal.PersonalFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private FragmentTransaction transaction;
    private FragmentManager manager;
    private List<Fragment> fragments;

    private RadioGroup rg;
    @Override
    protected void getViews() {
        rg = (RadioGroup) findViewById(R.id.main_rg);
    }

    @Override
    protected void initData() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        fragments = new ArrayList<>();
        fragments.add(new NewsFragment());
        fragments.add(new JokerFragment());
        fragments.add(new PersonalFragment());


        transaction.add(R.id.main_frame,fragments.get(0));
        transaction.add(R.id.main_frame,fragments.get(1));
        transaction.add(R.id.main_frame,fragments.get(2));

        transaction.show(fragments.get(0));
        transaction.hide(fragments.get(1));
        transaction.hide(fragments.get(2));

        transaction.commit();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindViewEvent() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                transaction = manager.beginTransaction();

                switch (i){

                    case R.id.rb_news:

                        transaction.show(fragments.get(0));
                        transaction.hide(fragments.get(1));
                        transaction.hide(fragments.get(2));
                        transaction.commit();

                        break;
                    case R.id.rb_joker:
                        transaction.show(fragments.get(1));
                        transaction.hide(fragments.get(0));
                        transaction.hide(fragments.get(2));
                        transaction.commit();

                        break;

                    case R.id.rb_me:
                        transaction.show(fragments.get(2));
                        transaction.hide(fragments.get(0));
                        transaction.hide(fragments.get(1));
                        transaction.commit();
                        break;

                }
            }
        });
    }

    @Override
    protected void loadData() {

    }
}

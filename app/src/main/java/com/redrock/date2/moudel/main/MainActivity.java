package com.redrock.date2.moudel.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends BaseActivity<MainPresenter> {

    @InjectView(R.id.container)
    FrameLayout container;
    @InjectView(R.id.date)
    LinearLayout date;
    @InjectView(R.id.action)
    LinearLayout action;
    @InjectView(R.id.post)
    LinearLayout post;
    @InjectView(R.id.message)
    LinearLayout message;
    @InjectView(R.id.user)
    LinearLayout user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setSwipeBackEnable(false);
        ButterKnife.inject(this);
        date.setOnClickListener(v -> getPresenter().showDateFragment());
        action.setOnClickListener(v->getPresenter().showActionFragment());
        post.setOnClickListener(v->getPresenter().startPost());
        message.setOnClickListener(v->getPresenter().showMessageFragment());
        user.setOnClickListener(v->getPresenter().showUserFragment());
    }

    public void showFragment(Fragment fragment) {
        JUtils.Log("fragment:"+fragment.getClass().getName());
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }

}

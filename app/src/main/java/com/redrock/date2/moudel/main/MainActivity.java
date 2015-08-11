package com.redrock.date2.moudel.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.DateType;
import com.umeng.update.UmengUpdateAgent;

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
    @InjectView(R.id.message)
    LinearLayout message;
    @InjectView(R.id.user)
    LinearLayout user;
    @InjectView(R.id.post)
    FloatingActionButton post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setSwipeBackEnable(false);
        UmengUpdateAgent.forceUpdate(this);
        ButterKnife.inject(this);
        date.setOnClickListener(v -> getPresenter().showDateFragment());
        action.setOnClickListener(v -> getPresenter().showActionFragment());
        post.setOnClickListener(v -> showDateTypeSelector());
        message.setOnClickListener(v -> getPresenter().showMessageFragment());
        user.setOnClickListener(v -> getPresenter().showUserFragment());
    }

    public void showFragment(Fragment fragment) {
        JUtils.Log("fragment:" + fragment.getClass().getName());
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void showDateTypeSelector(){
        DateType[] types = DateModel.getInstance().getDateType();
        String[] strings = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            strings[i] = types[i].getName();
        }
        new MaterialDialog.Builder(this)
                .title("请选择要发布的类型")
                .items(strings)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                       getPresenter().startPost(types[which].getId());
                    }
                })
                .show();
    }

}

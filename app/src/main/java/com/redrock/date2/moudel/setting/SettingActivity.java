package com.redrock.date2.moudel.setting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/13.
 */
@RequiresPresenter(SettingPresenter.class)
public class SettingActivity extends BaseActivity<SettingPresenter> {

    @InjectView(R.id.view_action)
    LinearLayout viewAction;
    @InjectView(R.id.view_about)
    LinearLayout viewAbout;
    @InjectView(R.id.view_feedback)
    LinearLayout viewFeedback;
    @InjectView(R.id.view_update)
    LinearLayout viewUpdate;
    @InjectView(R.id.view_sign_out)
    LinearLayout viewSignOut;
    @InjectView(R.id.view_update_log)
    LinearLayout viewUpdateLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity_setting);
        ButterKnife.inject(this);
        viewSignOut.setOnClickListener(v -> getPresenter().LoginOut());
        viewUpdateLog.setOnClickListener(v->startActivity(new Intent(this,UpdateLogActivity.class)));
    }
}

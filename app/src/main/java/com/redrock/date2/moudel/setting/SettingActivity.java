package com.redrock.date2.moudel.setting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.umeng.update.UmengUpdateAgent;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/13.
 */
@RequiresPresenter(SettingPresenter.class)
public class SettingActivity extends BeamBaseActivity<SettingPresenter> {

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
        viewUpdateLog.setOnClickListener(v->startActivity(new Intent(this, UpdateLogActivity.class)));
        viewAbout.setOnClickListener(v->startActivity(new Intent(this,AboutUsActivity.class)));
        viewFeedback.setOnClickListener(v->startActivity(new Intent(this,FeedBackActivity.class)));
        viewAction.setOnClickListener(v->startActivity(new Intent(this,NotifySettingActivity.class)));
        viewUpdate.setOnClickListener(v->{
            getExpansion().showProgressDialog("检查更新中");
            UmengUpdateAgent.forceUpdate(this);
            UmengUpdateAgent.setUpdateListener((i, updateResponse) -> {
                getExpansion().dismissProgressDialog();
                if (i == 1) {
                    JUtils.Toast("暂无更新");
                }
            });
        });
    }
}

package com.redrock.date2.moudel.setting;

import android.os.Bundle;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.redrock.date2.R;

/**
 * Created by Mr.Jude on 2015/8/14.
 */

@RequiresPresenter(NotifySettingPresenter.class)
public class NotifySettingActivity extends BeamBaseActivity<NotifySettingPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity_notify);
    }
}

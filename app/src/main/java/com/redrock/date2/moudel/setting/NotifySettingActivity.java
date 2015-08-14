package com.redrock.date2.moudel.setting;

import android.os.Bundle;

import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;

/**
 * Created by Mr.Jude on 2015/8/14.
 */

@RequiresPresenter(NotifySettingPresenter.class)
public class NotifySettingActivity extends BaseActivity<NotifySettingPresenter>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity_notify);
    }
}

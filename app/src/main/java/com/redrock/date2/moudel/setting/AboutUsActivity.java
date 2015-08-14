package com.redrock.date2.moudel.setting;

import android.os.Bundle;
import android.widget.TextView;

import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/14.
 */

@RequiresPresenter(AboutUsPresenter.class)
public class AboutUsActivity extends BaseActivity<AboutUsPresenter> {

    @InjectView(R.id.version)
    TextView version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity_about);
        ButterKnife.inject(this);
        version.setText("v"+JUtils.getAppVersionName());
    }

}

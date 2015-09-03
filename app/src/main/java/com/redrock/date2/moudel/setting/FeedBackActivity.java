package com.redrock.date2.moudel.setting;

import android.os.Bundle;
import android.view.Menu;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.redrock.date2.R;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
@RequiresPresenter(FeedBackPresenter.class)
public class FeedBackActivity extends BeamBaseActivity<FeedBackPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity_feedback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_send, menu);
        return true;
    }
}

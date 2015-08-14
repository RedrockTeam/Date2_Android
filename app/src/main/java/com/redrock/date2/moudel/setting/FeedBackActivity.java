package com.redrock.date2.moudel.setting;

import android.os.Bundle;
import android.view.Menu;

import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
@RequiresPresenter(FeedBackPresenter.class)
public class FeedBackActivity extends BaseActivity<FeedBackPresenter> {

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

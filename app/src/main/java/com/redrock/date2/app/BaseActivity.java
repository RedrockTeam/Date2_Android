package com.redrock.date2.app;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jude.beam.nucleus.manager.Presenter;
import com.jude.beam.nucleus.view.NucleusAppCompatActivity;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.redrock.date2.R;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class BaseActivity<T extends Presenter> extends NucleusAppCompatActivity<T> {
    private MaterialDialog dialog;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBackHelper.onCreate(this);
    }

    protected void setToolBar(boolean returnAble){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar!=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(returnAble);
        }
    }

    public void setSwipeBackEnable(boolean enable){
        SwipeBackHelper.getCurrentPage(this).setSwipeBackEnable(enable);
    }

    protected Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setToolBar(true);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setToolBar(true);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        setToolBar(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }

    public void showProgress(String title){
        dialog = new MaterialDialog.Builder(this)
                .title(title)
                .content("请稍候")
                .progress(true, 100)
                .cancelable(false)
                .show();
    }

    public void dismissProgress(){
        dialog.dismiss();
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}

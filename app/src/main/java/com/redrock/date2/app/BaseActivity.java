package com.redrock.date2.app;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

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

    private boolean mReturnAble = true;

    public void setReturnAble(boolean mReturnAble) {
        this.mReturnAble = mReturnAble;
    }

    private boolean init = false;
    private View mLoading;
    private ViewGroup mContent;
    private ViewGroup mContentParent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewTree();
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this).setSwipeSensitivity(0.2f);
    }


    public void addLoadingView(){
        initViewTree();
        mLoading = LayoutInflater.from(this).inflate(R.layout.activity_loading,mContentParent,false);
        mContentParent.addView(mLoading, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Toolbar toolbar = (Toolbar) mLoading.findViewById(R.id.toolbar);
        if (toolbar!=null)
            setToolbar(toolbar);
    }

    public void removeLoadingView(){
        initViewTree();
        mContentParent.removeView(mLoading);
        setToolbar(toolbar);
    }

    private void initViewTree(){
        if (init)return;
        mContentParent = (ViewGroup) findViewById(android.R.id.content);
        mContent = new FrameLayout(this);
        super.setContentView(mContent);
        init = true;
    }

    private void setToolbar(Toolbar toolbar){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(mReturnAble);
    }

    public void setSwipeBackEnable(boolean enable){
        SwipeBackHelper.getCurrentPage(this).setSwipeBackEnable(enable);
    }

    protected Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public void setContentView(int layoutResID) {
        this.setContentView(getLayoutInflater().inflate(layoutResID, mContent, false));
    }

    @Override
    public void setContentView(View view) {
        this.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mContent.addView(view,params);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        if (toolbar!=null)
            setToolbar(toolbar);
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

package com.redrock.date2.app;

import android.os.Bundle;

import com.jude.beam.bijection.ActivityLifeCycleDelegate;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by Mr.Jude on 2015/9/3.
 */
public class ActivityDelegate extends ActivityLifeCycleDelegate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBackHelper.onCreate(getActivity());
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(getActivity());
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(getActivity());
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onResume(getActivity());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(getActivity());
    }
}

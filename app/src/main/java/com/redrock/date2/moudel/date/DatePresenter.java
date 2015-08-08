package com.redrock.date2.moudel.date;

import android.os.Bundle;

import com.jude.beam.nucleus.manager.Presenter;
import com.jude.utils.JUtils;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class DatePresenter extends Presenter<DateFragment> {

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
    }

    @Override
    protected void onCreateView(DateFragment view) {
        super.onCreateView(view);
        JUtils.Log("DatePresenter onCreateView:"+getView().hashCode());
    }


}

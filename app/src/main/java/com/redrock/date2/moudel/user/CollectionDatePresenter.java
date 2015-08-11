package com.redrock.date2.moudel.user;

import android.os.Bundle;

import com.jude.beam.nucleus.manager.Presenter;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class CollectionDatePresenter extends Presenter<CollectionDateActivity> {
    private Date[] dates;
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        DateModel.getInstance().getJoinDate(new DataCallback<Date[]>() {
            @Override
            public void success(String info, Date[] data) {
                getView().addData(dates = data);
            }
        });
    }

    @Override
    protected void onCreateView(CollectionDateActivity view) {
        super.onCreateView(view);
        if (dates!=null)getView().addData(dates);
    }
}

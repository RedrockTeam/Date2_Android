package com.redrock.date2.moudel.user;

import android.os.Bundle;

import com.jude.beam.expansion.list.BeamListActivityPresenter;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class JoinDatePresenter extends BeamListActivityPresenter<JoinDateActivity,Date> {
    @Override
    protected void onCreate(JoinDateActivity view,Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        DateModel.getInstance().getJoinDate(new DataCallback<Date[]>() {
            @Override
            public void success(String info, Date[] data) {
                getAdapter().clear();
                getAdapter().addAll(data);
            }

            @Override
            public void error(String errorInfo) {
                getView().showError();
            }
        });
    }
}

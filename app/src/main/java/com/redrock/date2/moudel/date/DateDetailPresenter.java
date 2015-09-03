package com.redrock.date2.moudel.date;

import android.os.Bundle;

import com.jude.beam.expansion.data.BeamDataActivityPresenter;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.DateDetail;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
public class DateDetailPresenter extends BeamDataActivityPresenter<DateDetailActivity,DateDetail> {
    private String id;
    @Override
    protected void onCreate(DateDetailActivity view,Bundle savedState) {
        super.onCreate(view,savedState);
        getView().getExpansion().showProgressPage();
        id = getView().getIntent().getStringExtra("id");
        DateModel.getInstance().getDateDetail("0", new DataCallback<DateDetail>() {
            @Override
            public void success(String info, DateDetail data) {
                getView().getExpansion().dismissProgressPage();
                publishObject(data);
            }

            @Override
            public void error(String errorInfo) {
                getView().getExpansion().dismissProgressPage();
                publishError(new Exception(errorInfo));
            }
        });
    }

}

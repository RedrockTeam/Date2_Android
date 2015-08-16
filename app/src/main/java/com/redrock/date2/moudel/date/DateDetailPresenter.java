package com.redrock.date2.moudel.date;

import android.os.Bundle;

import com.jude.beam.nucleus.manager.Presenter;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.DateDetail;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
public class DateDetailPresenter extends Presenter<DateDetailActivity> {
    private String id;
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        getView().addLoadingView();
        id = getView().getIntent().getStringExtra("id");
        DateModel.getInstance().getDateDetail("0", new DataCallback<DateDetail>() {
            @Override
            public void success(String info, DateDetail data) {
                getView().removeLoadingView();
                getView().setDateDetail(data);
            }
        });
    }

}

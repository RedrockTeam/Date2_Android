package com.redrock.date2.moudel.action;

import android.os.Bundle;

import com.jude.beam.expansion.data.BeamDataActivityPresenter;
import com.redrock.date2.model.ActionModel;
import com.redrock.date2.model.bean.ActionDetail;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
public class ActionDetailPresenter extends BeamDataActivityPresenter<ActionDetailActivity,ActionDetail> {

    @Override
    protected void onCreate(ActionDetailActivity view,Bundle savedState) {
        super.onCreate(view,savedState);
        getView().getExpansion().showProgressPage();
        ActionModel.getInstance().getActionDetail(getView().getIntent().getStringExtra("id"), new DataCallback<ActionDetail>() {
            @Override
            public void success(String info, ActionDetail data) {
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

package com.redrock.date2.moudel.action;

import android.os.Bundle;

import com.jude.beam.nucleus.manager.Presenter;
import com.redrock.date2.model.ActionModel;
import com.redrock.date2.model.bean.ActionDetail;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
public class ActionDetailPresenter extends Presenter<ActionDetailActivity> {
    private ActionDetail detail;
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        ActionModel.getInstance().getActionDetail(getView().getIntent().getStringExtra("id"), new DataCallback<ActionDetail>() {
            @Override
            public void success(String info, ActionDetail data) {
                getView().setActionDetail(detail = data);
            }
        });
    }

    @Override
    protected void onCreateView(ActionDetailActivity view) {
        super.onCreateView(view);
        if (detail!=null)getView().setActionDetail(detail);
    }
}

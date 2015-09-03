package com.redrock.date2.moudel.action;

import android.os.Bundle;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.redrock.date2.model.ActionModel;
import com.redrock.date2.model.bean.Action;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class ActionPresenter extends BeamListFragmentPresenter<ActionFragment,Action> {
    private int page = 0;

    @Override
    protected void onCreate(ActionFragment view,Bundle savedState) {
        super.onCreate(view,savedState);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        ActionModel.getInstance().getAction(0, new DataCallback<Action[]>() {
            @Override
            public void success(String info, Action[] actions) {
                getAdapter().clear();
                getAdapter().addAll(actions);
                page=1;
            }

            @Override
            public void error(String errorInfo) {
                getView().showError();
            }
        });
    }

    @Override
    public void onLoadMore() {
        ActionModel.getInstance().getAction(page, new DataCallback<Action[]>() {
            @Override
            public void success(String info, Action[] actions) {
                getAdapter().addAll(actions);
                page++;
            }

            @Override
            public void error(String errorInfo) {
                getAdapter().pauseMore();
            }
        });
    }

}

package com.redrock.date2.moudel.action;

import android.os.Bundle;

import com.jude.beam.nucleus.manager.Presenter;
import com.redrock.date2.model.ActionModel;
import com.redrock.date2.model.bean.Action;
import com.redrock.date2.model.callback.DataCallback;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class ActionPresenter extends Presenter<ActionFragment> {
    private int page = 0;
    private ArrayList<Action> mDateArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        refresh();
    }

    @Override
    protected void onTakeView(ActionFragment view) {
        super.onTakeView(view);
        if (mDateArrayList.size()!=0){
            getView().stopRefresh();
            getView().addDate(mDateArrayList.toArray(new Action[0]));
        }
    }

    public void refresh(){
        ActionModel.getInstance().getAction(0, new DataCallback<Action[]>() {
            @Override
            public void success(String info, Action[] actions) {
                if (getView() !=null){
                    if (actions == null ||actions.length == 0) getView().stopRefresh();
                    else{
                        getView().stopRefresh();
                        getView().addDate(actions);
                        mDateArrayList.clear();
                        mDateArrayList.addAll(Arrays.asList(actions));
                        page = 1;
                    }
                }
            }
        });
    }

    public void loadMore(){
        ActionModel.getInstance().getAction(page, new DataCallback<Action[]>() {
            @Override
            public void success(String info, Action[] actions) {
                if (getView() != null) {
                    if (actions == null || actions.length == 0) getView().stopLoadMore();
                    else {
                        getView().addDate(actions);
                        mDateArrayList.addAll(Arrays.asList(actions));
                    }
                    page++;
                }
            }
        });
    }
}

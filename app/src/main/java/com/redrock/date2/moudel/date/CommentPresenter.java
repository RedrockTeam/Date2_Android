package com.redrock.date2.moudel.date;

import android.os.Bundle;

import com.jude.beam.expansion.list.BeamListActivityPresenter;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.Comment;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
public class CommentPresenter extends BeamListActivityPresenter<CommentActivity,Comment> {
    private int page;
    @Override
    protected void onCreate(CommentActivity view,Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        DateModel.getInstance().getComments(getView().getIntent().getStringExtra("id"), 0, new DataCallback<Comment[]>() {
            @Override
            public void success(String info, Comment[] data) {
                getAdapter().clear();
                getAdapter().addAll(data);
                page++;
            }

            @Override
            public void error(String s) {
                getView().showError();
            }
        });
    }

    @Override
    public void onLoadMore() {
        DateModel.getInstance().getComments(getView().getIntent().getStringExtra("id"), page,new DataCallback<Comment[]>() {
            @Override
            public void success(String info, Comment[] data) {
                getAdapter().addAll(data);
                page++;
            }

            @Override
            public void error(String s) {
                getAdapter().pauseMore();
            }
        });
    }


}

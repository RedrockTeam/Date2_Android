package com.redrock.date2.moudel.date;

import android.os.Bundle;

import com.jude.beam.nucleus.manager.Presenter;
import com.jude.utils.JUtils;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.Comment;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
public class CommentPresenter extends Presenter<CommentActivity> {
    private int page;
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        loadMore();
    }

    public void loadMore(){
        DateModel.getInstance().getComments(getView().getIntent().getStringExtra("id"), page,new DataCallback<Comment[]>() {
            @Override
            public void success(String info, Comment[] data) {
                JUtils.Log("success");
                getView().addData(data);
                page++;
            }
        });
    }
}

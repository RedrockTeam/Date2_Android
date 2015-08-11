package com.redrock.date2.moudel.date;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.redrock.date2.model.bean.Comment;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class CommentAdapter extends RecyclerArrayAdapter<Comment> {
    public CommentAdapter(Context context, Comment[] objects) {
        super(context, objects);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CommentViewHolder(viewGroup);
    }
}

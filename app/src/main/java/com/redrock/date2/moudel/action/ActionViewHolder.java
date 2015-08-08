package com.redrock.date2.moudel.action;

import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.Action;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/8.
 */
public class ActionViewHolder extends BaseViewHolder<Action> {
    @InjectView(R.id.image)
    SimpleDraweeView image;
    @InjectView(R.id.member)
    TextView member;
    @InjectView(R.id.comment)
    TextView comment;
    @InjectView(R.id.praise)
    TextView praise;
    @InjectView(R.id.ic_praise)
    ImageView icPraise;

    public ActionViewHolder(ViewGroup parent) {
        super(parent, R.layout.action_item_main);
        ButterKnife.inject(this,itemView);
    }

    @Override
    public void setData(Action data) {
        if (data.getImage()!=null)
            image.setImageURI(Uri.parse(data.getImage()));
        member.setText(data.getMemberCount());
        comment.setText(data.getCommentCount());
        praise.setText(data.getPraiseCount());
    }
}

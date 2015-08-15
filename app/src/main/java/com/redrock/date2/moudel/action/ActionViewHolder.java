package com.redrock.date2.moudel.action;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.Action;
import com.redrock.date2.utils.TAGView;

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
    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.tag)
    TAGView tag;
    @InjectView(R.id.ic_person)
    ImageView icPerson;

    public ActionViewHolder(ViewGroup parent) {
        super(parent, R.layout.action_item_main);
        ButterKnife.inject(this, itemView);
    }

    @Override
    public void setData(Action data) {
        image.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(JUtils.dip2px(2), JUtils.dip2px(2), 0, 0));
        if (data.getImage() != null)
            image.setImageURI(Uri.parse(data.getImage()));
        member.setText(data.getMemberCount());
        comment.setText(data.getCommentCount());
        praise.setText(data.getPraiseCount());
        title.setText(data.getTitle());
        if (data.getTag()!=null&&!data.getTag().isEmpty()){
            tag.setText(data.getTag());
            tag.setVisibility(View.VISIBLE);
        }else{
            tag.setVisibility(View.INVISIBLE);
        }
        itemView.setOnClickListener(v -> {
            v.getContext().startActivity(new Intent(v.getContext(), ActionDetailActivity.class));
        });
    }
}

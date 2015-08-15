package com.redrock.date2.moudel.date;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.utils.JTimeTransform;
import com.redrock.date2.R;
import com.redrock.date2.config.Constant;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.utils.RecentDateFormat;
import com.redrock.date2.utils.TAGView;
import com.redrock.date2.utils.YearAnalysis;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class DateViewHolder extends BaseViewHolder<Date> {

    @InjectView(R.id.face)
    SimpleDraweeView face;
    @InjectView(R.id.name)
    TextView name;
    @InjectView(R.id.post_time)
    TextView postTime;
    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.date)
    TextView date;
    @InjectView(R.id.address)
    TextView address;
    @InjectView(R.id.cost)
    TextView cost;
    @InjectView(R.id.member)
    TextView member;
    @InjectView(R.id.comment)
    TextView comment;
    @InjectView(R.id.praise)
    TextView praise;
    @InjectView(R.id.ic_praise)
    ImageView icPraise;
    @InjectView(R.id.style)
    TAGView style;

    @InjectView(R.id.ic_date)
    ImageView icDate;
    @InjectView(R.id.tag_user)
    TAGView tagUser;
    @InjectView(R.id.tag_certification)
    TAGView tagCertification;

    public DateViewHolder(ViewGroup parent) {
        super(parent, R.layout.date_item_main);
        ButterKnife.inject(this, itemView);
    }

    @Override
    public void setData(Date data) {
        if (data.getAuthorFace() != null)
            face.setImageURI(Uri.parse(data.getAuthorFace()));
        name.setText(data.getAuthorName());
        postTime.setText(new JTimeTransform(data.getPostTime()).toString(new RecentDateFormat("yyyy/MM/dd hh:mm")));
        title.setText(data.getTitle());
        date.setText(new JTimeTransform(data.getDate()).toString(new RecentDateFormat("MM月dd日 hh:mm")));
        address.setText(data.getAddress());
        cost.setText(data.getCostType());
        member.setText(data.getMemberCount());
        praise.setText(data.getPraiseCount());
        comment.setText(data.getMemberCount());

        tagUser.setIcon(data.getAuthorGender() == 1 ? R.drawable.ic_male_white : R.drawable.ic_female_white);
        tagUser.setText(YearAnalysis.analysis(data.getAuthorAge()));
        tagUser.setBackgroundColor(itemView.getContext().getResources().getColor(data.getAuthorGender() == 1 ? R.color.blue : R.color.pink));

        tagCertification.setVisibility(data.isCertification()? View.VISIBLE:View.INVISIBLE);

        style.setText(DateModel.getInstance().findDateTypeById(data.getType()).getName());
        style.setBackgroundColor(Color.parseColor(Constant.TYPE_COLOR[data.getType() % DateModel.getInstance().getDateType().length]));
        itemView.setOnClickListener(v -> v.getContext().startActivity(new Intent(v.getContext(), DateDetailActivity.class)));
    }
}

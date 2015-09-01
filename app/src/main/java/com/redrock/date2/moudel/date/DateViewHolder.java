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
import com.jude.tagview.TAGView;
import com.jude.utils.JTimeTransform;
import com.redrock.date2.R;
import com.redrock.date2.config.Constant;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.moudel.user.UserDetailActivity;
import com.redrock.date2.utils.RecentDateFormat;
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

    Date data;
    @InjectView(R.id.ic_person)
    ImageView icPerson;
    @InjectView(R.id.ic_comment)
    ImageView icComment;

    public DateViewHolder(ViewGroup parent) {
        super(parent, R.layout.date_item_main);
        ButterKnife.inject(this, itemView);
        tagUser.setWillNotCacheDrawing(true);
        comment.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), CommentActivity.class);
            v.getContext().startActivity(i);
        });
        icComment.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), CommentActivity.class);
            v.getContext().startActivity(i);
        });
        face.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), UserDetailActivity.class);
            i.putExtra("id", "id");//TODO 假数据
            v.getContext().startActivity(i);
        });
        name.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), UserDetailActivity.class);
            i.putExtra("id", "id");//TODO 假数据
            v.getContext().startActivity(i);
        });
        itemView.setOnClickListener(v -> {
            v.getContext().startActivity(new Intent(v.getContext(), DateDetailActivity.class));
        });
    }

    @Override
    public void setData(Date data) {
        this.data = data;
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

        tagUser.findViewById(R.id.text).setBackgroundColor(Color.BLUE);
        tagUser.findViewById(R.id.icon).setBackgroundColor(Color.RED);
        tagUser.setIcon(data.getAuthorGender() == 1 ? R.drawable.ic_male_white : R.drawable.ic_female_white);
        tagUser.setBackgroundColor(itemView.getContext().getResources().getColor(data.getAuthorGender() == 1 ? R.color.blue : R.color.pink));
        //tagUser.setText("告诉我为什么一定要写这句话，不然“大二”格子就会被“2008级”撑大。不是setText时就会重新布局吗。放心TAGView没有问题");
        tagUser.setText(YearAnalysis.analysis(data.getAuthorAge()));

        tagCertification.setVisibility(data.getAuthorRole() == 1 ? View.VISIBLE : View.INVISIBLE);

        style.setText(DateModel.getInstance().findDateTypeById(data.getType()).getName());
        int colorIndex = Math.abs(data.getType()) % DateModel.getInstance().getDateType().length;
        style.setBackgroundColor(Color.parseColor(Constant.TYPE_COLOR[colorIndex]));

    }
}

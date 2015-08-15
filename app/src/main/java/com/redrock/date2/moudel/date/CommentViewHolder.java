package com.redrock.date2.moudel.date;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.utils.JTimeTransform;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.Comment;
import com.redrock.date2.utils.RecentDateFormat;
import com.redrock.date2.utils.TAGView;
import com.redrock.date2.utils.YearAnalysis;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class CommentViewHolder extends BaseViewHolder<Comment> {
    @InjectView(R.id.face)
    SimpleDraweeView face;
    @InjectView(R.id.name)
    TextView name;
    @InjectView(R.id.time)
    TextView time;
    @InjectView(R.id.content)
    TextView content;
    @InjectView(R.id.tag_user)
    TAGView tagUser;
    @InjectView(R.id.tag_certification)
    TAGView tagCertification;

    public CommentViewHolder(ViewGroup parent) {
        super(parent, R.layout.date_item_comment);
        ButterKnife.inject(this, itemView);
    }

    @Override
    public void setData(Comment data) {
        if (data.getAuthorFace() != null) {
            face.setImageURI(Uri.parse(data.getAuthorFace()));
        }
        tagUser.setIcon(data.getAuthorGender() == 1 ? R.drawable.ic_male_white : R.drawable.ic_female_white);
        tagUser.setText(YearAnalysis.analysis(data.getAuthorAge()));
        tagUser.setBackgroundColor(itemView.getContext().getResources().getColor(data.getAuthorGender() == 1 ? R.color.blue : R.color.pink));

        tagCertification.setVisibility(data.isCertification() ? View.VISIBLE : View.INVISIBLE);
        name.setText(data.getAuthorName());
        time.setText(new JTimeTransform(data.getTime()).toString(new RecentDateFormat()));
        content.setText(data.getContent());
    }
}

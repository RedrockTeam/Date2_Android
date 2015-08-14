package com.redrock.date2.moudel.date;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.utils.JTimeTransform;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;
import com.redrock.date2.config.Constant;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.model.bean.DateDetail;
import com.redrock.date2.model.bean.User;
import com.redrock.date2.moudel.user.UserListActivity;
import com.redrock.date2.utils.LinearWrapContentRecyclerView;
import com.redrock.date2.utils.RecentDateFormat;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
@RequiresPresenter(DateDetailPresenter.class)
public class DateDetailActivity extends BaseActivity<DateDetailPresenter> {

    @InjectView(R.id.face)
    SimpleDraweeView face;
    @InjectView(R.id.name)
    TextView name;
    @InjectView(R.id.time_post)
    TextView timePost;
    @InjectView(R.id.btn_action)
    Button btnAction;
    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.time)
    TextView time;
    @InjectView(R.id.cost_type)
    TextView costType;
    @InjectView(R.id.member_count)
    TextView memberCount;
    @InjectView(R.id.address)
    TextView address;
    @InjectView(R.id.content)
    TextView content;
    @InjectView(R.id.post_count)
    TextView postCount;
    @InjectView(R.id.member)
    GridView member;
    @InjectView(R.id.comment_count)
    TextView commentCount;
    @InjectView(R.id.comment_list)
    LinearWrapContentRecyclerView commentList;
    @InjectView(R.id.comment)
    TextView comment;
    @InjectView(R.id.chat)
    TextView chat;
    @InjectView(R.id.collection)
    TextView collection;
    @InjectView(R.id.container_bottom)
    LinearLayout containerBottom;
    @InjectView(R.id.view_member)
    LinearLayout viewMember;
    @InjectView(R.id.view_comment)
    LinearLayout viewComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_activity_detail);
        ButterKnife.inject(this);
    }

    public void setDateDetail(DateDetail dateDetail) {
        if (dateDetail.getAuthor().getFace() != null)
            face.setImageURI(Uri.parse(dateDetail.getAuthor().getFace()));
        name.setText(dateDetail.getAuthor().getName());
        title.setText(dateDetail.getTitle());
        timePost.setText(new JTimeTransform(dateDetail.getPostTime()).toString(new RecentDateFormat()));
        time.setText("· " + new JTimeTransform(dateDetail.getTime()).toString(new RecentDateFormat()));
        costType.setText("· " + Constant.COST_TYPE[dateDetail.getCostType()]);
        memberCount.setText("· " + dateDetail.getMemberCount() + "人");
        address.setText("· " + dateDetail.getAddress());
        content.setText("· " + dateDetail.getContent());

        if (dateDetail.getMember() != null) {
            postCount.setText(dateDetail.getMember().length + "人已报名");
            member.setAdapter(new FaceAdapter(DateDetailActivity.this, dateDetail.getMember()));
            viewMember.setOnClickListener(v -> {
                Intent i = new Intent(this, UserListActivity.class);
                i.putExtra("users", dateDetail.getMember());
                i.putExtra("title", "报名列表");
                startActivity(i);
            });
        } else {
            member.setAdapter(new FaceAdapter(this, new User[]{UserModel.getInstance().createEmptyUser()}));
            postCount.setText(0 + "人已报名");
        }

        if (dateDetail.getComments() != null) {
            commentCount.setText(dateDetail.getComments().length + "条评论");
            commentList.setAdapter(new CommentAdapter(DateDetailActivity.this, dateDetail.getComments()));
            viewComment.setOnClickListener(v->{
                Intent i = new Intent(this, CommentActivity.class);
                startActivity(i);
            });
        } else {
            commentCount.setText("0条评论");
        }
    }


}

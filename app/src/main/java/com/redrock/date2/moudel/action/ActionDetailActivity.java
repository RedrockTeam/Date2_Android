package com.redrock.date2.moudel.action;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.tagview.TAGView;
import com.jude.utils.JTimeTransform;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.model.bean.ActionDetail;
import com.redrock.date2.model.bean.User;
import com.redrock.date2.moudel.date.CommentActivity;
import com.redrock.date2.moudel.date.CommentAdapter;
import com.redrock.date2.moudel.date.FaceAdapter;
import com.redrock.date2.moudel.user.UserListActivity;
import com.redrock.date2.utils.LinearWrapContentRecyclerView;
import com.redrock.date2.utils.RecentDateFormat;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
@RequiresPresenter(ActionDetailPresenter.class)
public class ActionDetailActivity extends BaseActivity<ActionDetailPresenter> {

    @InjectView(R.id.time)
    TextView time;
    @InjectView(R.id.address)
    TextView address;
    @InjectView(R.id.cost)
    TextView cost;
    @InjectView(R.id.content)
    TextView content;
    @InjectView(R.id.join_count)
    TextView joinCount;
    @InjectView(R.id.member)
    GridView member;
    @InjectView(R.id.image)
    SimpleDraweeView image;
    @InjectView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @InjectView(R.id.appBar)
    AppBarLayout appBar;
    @InjectView(R.id.floating_action_button)
    FloatingActionButton floatingActionButton;
    @InjectView(R.id.tag)
    TAGView tag;
    @InjectView(R.id.comment_count)
    TextView commentCount;
    @InjectView(R.id.comment_list)
    LinearWrapContentRecyclerView commentList;
    @InjectView(R.id.view_member)
    LinearLayout viewMember;
    @InjectView(R.id.view_comment)
    LinearLayout viewComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_activity_detail);
        ButterKnife.inject(this);
    }

    public void setActionDetail(ActionDetail detail) {
        collapsingToolbar.setTitle(detail.getTitle());
        time.setText(new JTimeTransform(detail.getTime()).toString(new RecentDateFormat()));
        address.setText(detail.getAddress());
        cost.setText(detail.getCost());
        content.setText(detail.getContent());
        if (detail.getTag().isEmpty()) {
            tag.setVisibility(View.INVISIBLE);
        } else {
            tag.setText(detail.getTag());
        }
        if (detail.getImage() != null)
            image.setImageURI(Uri.parse(detail.getImage()));
        if (detail.getMember() != null) {
            joinCount.setText(detail.getMember().length + "人参加");
            member.setAdapter(new FaceAdapter(this, detail.getMember()));
            viewMember.setOnClickListener(v -> {
                Intent i = new Intent(this, UserListActivity.class);
                i.putExtra("users", detail.getMember());
                i.putExtra("title", "报名列表");
                startActivity(i);
            });
        } else {
            member.setAdapter(new FaceAdapter(this, new User[]{UserModel.getInstance().createEmptyUser()}));
            joinCount.setText("0人参加");
        }
        if (detail.getComment() != null) {
            commentCount.setText(detail.getComment().length + "条评论");
            commentList.setAdapter(new CommentAdapter(this, detail.getComment()));
            viewComment.setOnClickListener(v->{
                Intent i = new Intent(this, CommentActivity.class);
                startActivity(i);
            });
        } else {
            commentCount.setText("0条评论");
        }
    }
}

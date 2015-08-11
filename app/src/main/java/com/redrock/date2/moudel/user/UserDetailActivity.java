package com.redrock.date2.moudel.user;

import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;
import com.redrock.date2.model.bean.UserDetail;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
@RequiresPresenter(UserDetailPresenter.class)
public class UserDetailActivity extends BaseActivity<UserDetailPresenter> {

    @InjectView(R.id.face)
    SimpleDraweeView face;
    @InjectView(R.id.name)
    TextView name;
    @InjectView(R.id.sign)
    TextView sign;
    @InjectView(R.id.real_name)
    TextView realName;
    @InjectView(R.id.school)
    TextView school;
    @InjectView(R.id.hobby)
    TextView hobby;
    @InjectView(R.id.view_publish)
    LinearLayout viewPublish;
    @InjectView(R.id.view_collection)
    LinearLayout viewCollection;
    @InjectView(R.id.charm_value)
    TextView charmValue;
    @InjectView(R.id.attention_count)
    TextView attentionCount;
    @InjectView(R.id.fans_count)
    TextView fansCount;
    @InjectView(R.id.attention)
    TextView attention;
    @InjectView(R.id.chat)
    TextView chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_detail);
        ButterKnife.inject(this);
    }

    public void setUserDetail(UserDetail userDetail) {
        if (userDetail.getFace() != null)
            face.setImageURI(Uri.parse(userDetail.getFace()));
        name.setText(userDetail.getName());
        sign.setText(userDetail.getSign());
        realName.setText(userDetail.getRealName());
        school.setText(userDetail.getSchool());
        hobby.setText(userDetail.getTag());
        attentionCount.setText(userDetail.getAttentionCount());
        fansCount.setText(userDetail.getFansCount());
        charmValue.setText(userDetail.getCharmValue());
    }

}

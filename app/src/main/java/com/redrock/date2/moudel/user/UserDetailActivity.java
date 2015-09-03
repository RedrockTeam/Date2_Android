package com.redrock.date2.moudel.user;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.data.BeamDataActivity;
import com.redrock.date2.R;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.model.bean.UserDetail;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
@RequiresPresenter(UserDetailPresenter.class)
public class UserDetailActivity extends BeamDataActivity<UserDetailPresenter,UserDetail> {

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
    @InjectView(R.id.view_attention)
    LinearLayout viewAttention;
    @InjectView(R.id.view_fans)
    LinearLayout viewFans;
    @InjectView(R.id.container)
    LinearLayout container;
    @InjectView(R.id.gender)
    ImageView gender;
    @InjectView(R.id.age)
    TextView age;

    private boolean isUser = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_detail);
        ButterKnife.inject(this);
        viewAttention.setOnClickListener(v -> getPresenter().startAttention());
        viewFans.setOnClickListener(v -> getPresenter().startFans());
        viewPublish.setOnClickListener(v -> getPresenter().startJoinDate());
        viewCollection.setOnClickListener(v -> getPresenter().startCollection());
    }

    @Override
    public void setData(UserDetail userDetail) {
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
        gender.setImageResource(userDetail.getGender() == 1 ? R.drawable.ic_male_focus : R.drawable.ic_male_unfocus);
        age.setText(userDetail.getAge() + "级");
        setIsUser(userDetail.getId().equals(UserModel.getInstance().getAccount().getId()));
    }



    public void setIsUser(boolean isUser){
        this.isUser = isUser;
        invalidateOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit,menu);
        return isUser;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.edit){
            startActivity(new Intent(this,UserEditActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

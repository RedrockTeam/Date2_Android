package com.redrock.date2.moudel.user;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.beam.bijection.BeamFragment;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.UserDetail;
import com.redrock.date2.moudel.setting.SettingActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
@RequiresPresenter(UserPresenter.class)
public class UserFragment extends BeamFragment<UserPresenter> {
    @InjectView(R.id.face)
    SimpleDraweeView face;
    @InjectView(R.id.sign)
    TextView sign;
    @InjectView(R.id.attention)
    TextView attention;
    @InjectView(R.id.fans)
    TextView fans;
    @InjectView(R.id.view_collection)
    LinearLayout viewCollection;
    @InjectView(R.id.view_record)
    LinearLayout viewRecord;
    @InjectView(R.id.view_certification)
    LinearLayout viewCertification;
    @InjectView(R.id.view_contact)
    LinearLayout viewContact;
    @InjectView(R.id.name)
    TextView name;
    @InjectView(R.id.container)
    RelativeLayout container;
    @InjectView(R.id.view_attention)
    LinearLayout viewAttention;
    @InjectView(R.id.view_fans)
    LinearLayout viewFans;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup c, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment, c, false);
        setHasOptionsMenu(true);
        ButterKnife.inject(this, view);
        container.setOnClickListener(v -> getPresenter().startUserDetail());
        viewAttention.setOnClickListener(v -> getPresenter().startAttention());
        viewFans.setOnClickListener(v -> getPresenter().startFans());
        viewRecord.setOnClickListener(v -> getPresenter().startJoinDate());
        viewCollection.setOnClickListener(v -> getPresenter().startCollection());
        viewContact.setOnClickListener(v->getPresenter().startContact());
        viewCertification.setOnClickListener(v->getPresenter().startCertification());
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_setting, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.setting){
            startActivity(new Intent(getActivity(), SettingActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public void setUser(UserDetail user) {
        if (user != null) {
            if (user.getFace() != null)
                face.setImageURI(Uri.parse(user.getFace()));
            name.setText(user.getName());
            sign.setText(user.getSign());
            attention.setText(user.getAttentionCount());
            fans.setText(user.getFansCount());
        }else{
            face.setImageURI(JUtils.getUriFromRes(R.drawable.ic_person));
            name.setText("点击登录");
            sign.setText("");
            attention.setText("0");
            fans.setText("0");
        }
    }
}

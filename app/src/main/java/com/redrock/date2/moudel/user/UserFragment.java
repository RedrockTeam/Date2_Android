package com.redrock.date2.moudel.user;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.beam.nucleus.view.NucleusFragment;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.User;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
@RequiresPresenter(UserPresenter.class)
public class UserFragment extends NucleusFragment<UserPresenter> {
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public void setUser(User user) {
        if (user != null) {
            if (user.getFace() != null)
                face.setImageURI(Uri.parse(user.getFace()));
            name.setText(user.getName());
            sign.setText(user.getSign());
            attention.setText(user.getAttentionCount());
            fans.setText(user.getFansCount());
        }
    }
}

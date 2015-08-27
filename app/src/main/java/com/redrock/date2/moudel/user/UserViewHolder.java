package com.redrock.date2.moudel.user;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.User;
import com.redrock.date2.utils.TAGView;
import com.redrock.date2.utils.YearAnalysis;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class UserViewHolder extends BaseViewHolder<User> {
    @InjectView(R.id.face)
    SimpleDraweeView face;
    @InjectView(R.id.name)
    TextView name;
    @InjectView(R.id.sign)
    TextView sign;
    @InjectView(R.id.tag_user)
    TAGView tagUser;
    @InjectView(R.id.tag_certification)
    TAGView tagCertification;

    public UserViewHolder(ViewGroup parent) {
        super(parent, R.layout.user_item_main);
        ButterKnife.inject(this, itemView);
    }

    @Override
    public void setData(User data) {
        if (data.getFace() != null)
            face.setImageURI(Uri.parse(data.getFace()));
        name.setText(data.getName());
        sign.setText(data.getSign());

        tagUser.setIcon(data.getGender() == 1 ? R.drawable.ic_male_white : R.drawable.ic_female_white);
        tagUser.setText(YearAnalysis.analysis(data.getAge()));
        tagUser.setBackgroundColor(itemView.getContext().getResources().getColor(data.getGender() == 1 ? R.color.blue : R.color.pink));

        tagCertification.setVisibility(data.getRole()==1 ? View.VISIBLE : View.INVISIBLE);

        itemView.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), UserDetailActivity.class);
            i.putExtra("id", data.getId());
            v.getContext().startActivity(i);
        });
    }
}

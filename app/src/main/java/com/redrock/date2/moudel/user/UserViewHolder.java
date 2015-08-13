package com.redrock.date2.moudel.user;

import android.net.Uri;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.User;

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

    public UserViewHolder(ViewGroup parent) {
        super(parent, R.layout.user_item_main);
        ButterKnife.inject(this,itemView);
    }

    @Override
    public void setData(User data) {
        if (data.getFace()!=null)
            face.setImageURI(Uri.parse(data.getFace()));
        name.setText(data.getName());
        sign.setText(data.getSign());
    }
}
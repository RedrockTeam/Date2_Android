package com.redrock.date2.moudel.date;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.utils.JUtils;
import com.redrock.date2.model.bean.User;

public class FaceAdapter extends ArrayAdapter<User> {

        public FaceAdapter(Context context, User[] objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SimpleDraweeView image = new SimpleDraweeView(parent.getContext());
            image.setLayoutParams(new AbsListView.LayoutParams(JUtils.dip2px(48),JUtils.dip2px(48)));
            RoundingParams roundingParams = RoundingParams.asCircle();
            image.getHierarchy().setRoundingParams(roundingParams);
            if (getItem(position).getFace()!=null)
            image.setImageURI(Uri.parse(getItem(position).getFace()));
            return image;
        }
    }
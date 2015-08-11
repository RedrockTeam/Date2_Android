package com.redrock.date2.moudel.user;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.redrock.date2.model.bean.User;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class UserAdapter extends RecyclerArrayAdapter<User>{
    public UserAdapter(Context context, User[] objects) {
        super(context, objects);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
        return new UserViewHolder(viewGroup);
    }
}

package com.redrock.date2.moudel.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.beam.bijection.BeamFragment;
import com.jude.beam.bijection.RequiresPresenter;
import com.redrock.date2.R;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
@RequiresPresenter(MessagePresenter.class)
public class MessageFragment extends BeamFragment<MessagePresenter> {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_fragment,container,false);

        return view;
    }

}

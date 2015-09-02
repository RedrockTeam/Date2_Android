package com.redrock.date2.moudel.date;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.redrock.date2.R;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
public class BRViewAdapter extends ArrayAdapter<String> {
    private ViewGroup container;
    private int target;
    private onSelectListener listener;
    public interface onSelectListener{
        void onSelect(int  index);
    }

    public BRViewAdapter(Context context, ViewGroup container, String[] objects, onSelectListener listener) {
        super(context, 0, objects);
        this.container = container;
        this.listener = listener;
        registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                container.removeAllViews();
                for (int i = 0; i < getCount(); i++) {
                    container.addView(getView(i,null,container));
                }
            }
        });
        notifyDataSetChanged();
    }

    public void setFocusIndex(int index){
        if (index>=getCount())index=0;
        select(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = LayoutInflater.from(getContext()).inflate(
                target == position ? R.layout.view_focus : R.layout.view_unfocus, parent, false);
        Button textView = (Button)rootView.findViewById(R.id.text);
        textView.setTextColor(target != position ? Color.DKGRAY : Color.WHITE);
        textView.setText(getItem(position));
        textView.setOnClickListener(v -> select(position));
        return rootView;
    }

    private void select(int position){
        target = position;
        notifyDataSetChanged();
        listener.onSelect(position);
    }
}

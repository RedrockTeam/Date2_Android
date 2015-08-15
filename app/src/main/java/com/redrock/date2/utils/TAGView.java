package com.redrock.date2.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.redrock.date2.R;

/**
 * Created by Mr.Jude on 2015/8/15.
 */
public class TAGView extends FrameLayout {
    private int icon;
    private String text;
    private int color;

    private LinearLayout mContainer;
    private ImageView mImageView;
    private TextView mTextView;

    public TAGView(Context context) {
        this(context,null);
    }

    public TAGView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TAGView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public void init(AttributeSet attrs){
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TAGView);;
        try {
            icon = a.getResourceId(R.styleable.TAGView_tag_icon,0);
            text = a.getString(R.styleable.TAGView_tag_text);
            color = a.getColor(R.styleable.TAGView_tag_color,Color.BLUE);
        }finally {
            a.recycle();
        }
        mContainer = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.view_tag,this,false);
        addView(mContainer);
        mImageView = (ImageView) mContainer.findViewById(R.id.icon);
        mTextView = (TextView) mContainer.findViewById(R.id.text);
        setIcon(icon);
        setText(text);
        setBackgroundColor(color);
    }

    public void setText(String text){
        mTextView.setText(text);
    }

    public void setIcon(int res){
        if (res == 0)removeIcon();
        else {
            mImageView.setVisibility(VISIBLE);
            mImageView.setImageResource(res);
        }

    }

    public void removeIcon(){
        mImageView.setVisibility(GONE);
    }

    public void setBackgroundColor(int color){
        GradientDrawable drawable = (GradientDrawable) mContainer.getBackground();
        drawable.mutate();
        drawable.setColor(color);
    }

}

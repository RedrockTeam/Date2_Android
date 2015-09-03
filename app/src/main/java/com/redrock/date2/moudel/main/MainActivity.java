package com.redrock.date2.moudel.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.DateType;
import com.umeng.update.UmengUpdateAgent;

import butterknife.ButterKnife;
import butterknife.InjectView;

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends BeamBaseActivity<MainPresenter> {

    @InjectView(R.id.container)
    FrameLayout container;
    @InjectView(R.id.date)
    LinearLayout date;
    @InjectView(R.id.action)
    LinearLayout action;
    @InjectView(R.id.message)
    LinearLayout message;
    @InjectView(R.id.user)
    LinearLayout user;
    @InjectView(R.id.post)
    ImageView post;
    @InjectView(R.id.img_main)
    ImageView imgMain;
    @InjectView(R.id.tv_main)
    TextView tvMain;
    @InjectView(R.id.img_find)
    ImageView imgFind;
    @InjectView(R.id.tv_find)
    TextView tvFind;
    @InjectView(R.id.img_message)
    ImageView imgMessage;
    @InjectView(R.id.tv_message)
    TextView tvMessage;
    @InjectView(R.id.img_user)
    ImageView imgUser;
    @InjectView(R.id.tv_user)
    TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        SwipeBackHelper.getCurrentPage(this).setSwipeBackEnable(false);
        UmengUpdateAgent.forceUpdate(this);
        ButterKnife.inject(this);
        date.setOnClickListener(v -> getPresenter().showDateFragment());
        action.setOnClickListener(v -> getPresenter().showActionFragment());
        post.setOnClickListener(v -> showDateTypeSelector());
        message.setOnClickListener(v -> getPresenter().showMessageFragment());
        user.setOnClickListener(v -> getPresenter().showUserFragment());
    }

    public void setFocus(int focusIndex) {
        ImageView[] imgs = new ImageView[]{imgMain,imgFind,imgMessage,imgUser};
        TextView[] tvs = new TextView[]{tvMain,tvFind,tvMessage,tvUser};
        int[] resFocus = new int[]{R.drawable.tab_main_focus,R.drawable.tab_find_focus,R.drawable.tab_message_focus,R.drawable.tab_user_focus};
        int[] resUnFocus = new int[]{R.drawable.tab_main_unfocus,R.drawable.tab_find_unfocus,R.drawable.tab_message_unfocus,R.drawable.tab_user_unfocus};
        for (int i = 0; i < 4; i++) {
            if (i==focusIndex){
                imgs[i].setImageResource(resFocus[i]);
                tvs[i].setTextColor(getResources().getColor(R.color.orange));
            }else{
                imgs[i].setImageResource(resUnFocus[i]);
                tvs[i].setTextColor(getResources().getColor(R.color.gray_deep));
            }
        }
    }

    public void showFragment(Fragment fragment) {
        JUtils.Log("fragment:" + fragment.getClass().getName());
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void showDateTypeSelector() {
        DateType[] types = DateModel.getInstance().getDateTypeFather();
        String[] strings = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            strings[i] = types[i].getName();
        }
        new MaterialDialog.Builder(this)
                .title("请选择要发布的类型")
                .items(strings)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        getPresenter().startPost(types[which].getId());
                    }
                })
                .show();
    }

}

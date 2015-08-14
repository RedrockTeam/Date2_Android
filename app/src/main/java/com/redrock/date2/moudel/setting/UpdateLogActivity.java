package com.redrock.date2.moudel.setting;

import android.os.Bundle;
import android.widget.TextView;

import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.http.RequestListener;
import com.jude.http.RequestManager;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/13.
 */
@RequiresPresenter(UpdateLogPresenter.class)
public class UpdateLogActivity extends BaseActivity<UpdateLogPresenter> {

    @InjectView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity_updatelog);
        ButterKnife.inject(this);
        showProgress("加载中");
        RequestManager.getInstance().get("https://raw.githubusercontent.com/RedrockTeam/Date2_Android/master/updateLog.txt", new RequestListener() {
            @Override
            public void onRequest() {

            }

            @Override
            public void onSuccess(String s) {
                dismissProgress();
                text.setText(s);
            }

            @Override
            public void onError(String s) {
                dismissProgress();
            }
        });
    }
}

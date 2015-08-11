package com.redrock.date2.moudel.user;

import android.os.Bundle;
import android.text.InputType;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jude.beam.nucleus.factory.RequiresPresenter;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
@RequiresPresenter(ContactPresenter.class)
public class ContactActivity extends BaseActivity<ContactPresenter> {

    @InjectView(R.id.tv_phone)
    TextView tvPhone;
    @InjectView(R.id.status_phone)
    TextView statusPhone;
    @InjectView(R.id.tv_wechat)
    TextView tvWechat;
    @InjectView(R.id.status_wechat)
    TextView statusWechat;
    @InjectView(R.id.tv_qq)
    TextView tvQq;
    @InjectView(R.id.status_qq)
    TextView statusQq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_contact);
        ButterKnife.inject(this);
        statusQq.setOnClickListener( v ->showQQEdit());
        statusWechat.setOnClickListener( v ->showWeChatEdit());
    }

    public void showQQEdit(){
        new MaterialDialog.Builder(this)
                .title("输入QQ号")
                .inputMaxLength(15)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .input("", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        try {
                            //getPresenter().setMemberCount(Integer.parseInt(input.toString()));
                            tvQq.setText(input);
                        } catch (NumberFormatException e) {
                            JUtils.Toast("请输入数字");
                        }
                    }
                }).show();
    }

    public void showWeChatEdit(){
        new MaterialDialog.Builder(this)
                .title("输入微信号")
                .inputMaxLength(15)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .input("", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        try {
                            //getPresenter().setMemberCount(Integer.parseInt(input.toString()));
                            tvWechat.setText(input);
                        } catch (NumberFormatException e) {
                            JUtils.Toast("请输入数字");
                        }
                    }
                }).show();
    }
}

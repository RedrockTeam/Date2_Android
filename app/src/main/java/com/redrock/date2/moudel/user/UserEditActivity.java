package com.redrock.date2.moudel.user;

import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.UserDetail;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/15.
 */
@RequiresPresenter(UserEditPresenter.class)
public class UserEditActivity extends BeamBaseActivity<UserEditPresenter> {

    @InjectView(R.id.face)
    SimpleDraweeView face;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.view_name)
    LinearLayout viewName;
    @InjectView(R.id.tv_sign)
    TextView tvSign;
    @InjectView(R.id.view_sign)
    LinearLayout viewSign;
    @InjectView(R.id.tv_tag)
    TextView tvTag;
    @InjectView(R.id.view_tag)
    LinearLayout viewTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_detailedit);
        ButterKnife.inject(this);
        viewName.setOnClickListener(v->showNameEdit());
        viewSign.setOnClickListener(v->showSignEdit());
        face.setOnClickListener(v -> showFaceEdit());
    }

    public void  setUser(UserDetail user){
        if (user.getFace()!=null)
            face.setImageURI(Uri.parse(user.getFace()));
        tvName.setText(user.getName());
        tvSign.setText(user.getSign());
        tvTag.setText(user.getTag());
    }

    public void setUserFace(Uri uri){
        face.setImageURI(uri);
    }

    private void showFaceEdit(){
        new MaterialDialog.Builder(this)
                .title("选择图片来源")
                .items(new String[]{"拍照","相册","网络"})
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
                        getPresenter().editFace(i);
                    }
                }).show();
    }

    private void showSignEdit(){
        new MaterialDialog.Builder(this)
                .title("输入约会宣言")
                .inputType(InputType.TYPE_CLASS_TEXT)
                .inputMaxLength(30)
                .input("", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        tvSign.setText(input);
                        getPresenter().setSign(input.toString());
                    }
                }).show();
    }

    private void showNameEdit(){
        new MaterialDialog.Builder(this)
                .title("输入昵称")
                .inputType(InputType.TYPE_CLASS_TEXT)
                .inputMaxLength(8)
                .input("", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        tvName.setText(input);
                        getPresenter().setName(input.toString());
                    }
                }).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_send, menu);
        return true;
    }
}

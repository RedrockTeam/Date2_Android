package com.redrock.date2.moudel.launch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.utils.JUtils;
import com.redrock.date2.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/13.
 */

@RequiresPresenter(RegisterPresenter.class)
public class RegisterActivity extends BeamBaseActivity<RegisterPresenter> {


    @InjectView(R.id.img_male)
    ImageView imgMale;
    @InjectView(R.id.tv_male)
    TextView tvMale;
    @InjectView(R.id.img_female)
    ImageView imgFemale;
    @InjectView(R.id.tv_female)
    TextView tvFemale;
    @InjectView(R.id.send)
    Button send;
    @InjectView(R.id.name)
    EditText name;
    @InjectView(R.id.phone)
    EditText phone;

    boolean gender = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity_register);
        ButterKnife.inject(this);
        imgFemale.setOnClickListener(v -> setGender(true));
        tvFemale.setOnClickListener(v -> setGender(true));
        imgMale.setOnClickListener(v -> setGender(false));
        tvMale.setOnClickListener(v -> setGender(false));
        send.setOnClickListener(v->checkInput());
    }

    public void checkInput() {
        if (name.getText().toString().isEmpty()){
            JUtils.Toast("请输入昵称");
            return;
        }
        if (phone.getText().toString().length()!=11){
            JUtils.Toast("请输入正确手机号");
            return;
        }
        Intent i = new Intent(this,VerifyActivity.class);
        i.putExtra("phone",phone.getText().toString());
        i.putExtra("name",name.getText().toString());
        i.putExtra("gender",gender);
        startActivity(i);
        finish();
    }

    public void setGender(boolean gender) {
        this.gender = gender;
        imgMale.setImageResource(gender ? R.drawable.ic_male_unfocus : R.drawable.ic_male_focus);
        imgFemale.setImageResource(gender ? R.drawable.ic_female_focus : R.drawable.ic_female_unfocus);
    }
}

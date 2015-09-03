package com.redrock.date2.moudel.date;

import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.library.imageprovider.Utils;
import com.jude.utils.JTimeTransform;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.config.Constant;
import com.redrock.date2.model.bean.DateType;
import com.redrock.date2.utils.RecentDateFormat;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/9.
 */

@RequiresPresenter(WriteDatePresenter.class)
public class WriteDateActivity extends BeamBaseActivity<WriteDatePresenter> {

    @InjectView(R.id.tv_style)
    TextView tvStyle;
    @InjectView(R.id.view_style)
    LinearLayout viewStyle;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.view_title)
    LinearLayout viewTitle;
    @InjectView(R.id.tv_member_count)
    TextView tvMemberCount;
    @InjectView(R.id.view_member_count)
    LinearLayout viewMemberCount;
    @InjectView(R.id.tv_cost)
    TextView tvCost;
    @InjectView(R.id.view_cost)
    LinearLayout viewCost;
    @InjectView(R.id.tv_date)
    TextView tvDate;
    @InjectView(R.id.view_date)
    LinearLayout viewDate;
    @InjectView(R.id.tv_address)
    TextView tvAddress;
    @InjectView(R.id.view_address)
    LinearLayout viewAddress;
    @InjectView(R.id.tv_gender)
    TextView tvGender;
    @InjectView(R.id.view_gender)
    LinearLayout viewGender;
    @InjectView(R.id.tv_school)
    TextView tvSchool;
    @InjectView(R.id.view_school)
    LinearLayout viewSchool;
    @InjectView(R.id.tv_content)
    TextView tvContent;
    @InjectView(R.id.view_content)
    LinearLayout viewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_activity_write);
        ButterKnife.inject(this);
        viewTitle.setOnClickListener(v -> showTitleEdit());
        viewAddress.setOnClickListener(v -> showAddressEdit());
        viewCost.setOnClickListener(v -> showCostTypeEdit());
        viewDate.setOnClickListener(v -> showTimeEdit());
        viewGender.setOnClickListener(v -> showGenderEdit());
        viewMemberCount.setOnClickListener(v -> showMemberCountEdit());
        viewContent.setOnClickListener(v -> showContentEditor());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_send, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.submit) {
            getPresenter().publish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void setDateType(DateType dateType) {
        tvStyle.setText(dateType.getName());
    }

    private void showTitleEdit() {
        new MaterialDialog.Builder(this)
                .title("输入标题")
                .inputType(InputType.TYPE_CLASS_TEXT)
                .inputMaxLength(30)
                .input("", tvTitle.getText(), new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        if (input.toString().trim().isEmpty()) {
                            JUtils.Toast("标题不能为空");
                            return;
                        }
                        tvTitle.setText(input);
                        getPresenter().setTitle(input.toString());
                    }
                }).show();
    }

    private void showMemberCountEdit() {
        new MaterialDialog.Builder(this)
                .title("输入约会人数")
                .inputMaxLength(2)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .input("", tvMemberCount.getText(), new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        try {
                            getPresenter().setMemberCount(Integer.parseInt(input.toString()));
                            tvMemberCount.setText(input);
                        } catch (NumberFormatException e) {
                            JUtils.Toast("请输入数字");
                        }
                    }
                }).show();
    }

    private void showCostTypeEdit() {
        new MaterialDialog.Builder(this)
                .title("请选择消费方式")
                .items(Constant.COST_TYPE)
                .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        tvCost.setText(text);
                        getPresenter().setCostType(which);
                        return true;
                    }
                })
                .positiveText("确定")
                .show();
    }

    private void showTimeEdit() {
        final Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                (datePickerDialog, i, i1, i2) -> {
                    now.set(i, i1, i2);
                    TimePickerDialog tpd = TimePickerDialog.newInstance((radialPickerLayout, i3, i11) -> {
                                now.set(Calendar.HOUR_OF_DAY, i3);
                                now.set(Calendar.MINUTE, i11);
                                if (now.getTimeInMillis() < System.currentTimeMillis()) {
                                    JUtils.Toast("逝去的时光不能重来，请重新选择");
                                    return;
                                }
                                tvDate.setText(new JTimeTransform(now.getTimeInMillis() / 1000).toString(new RecentDateFormat()));
                                getPresenter().setTime(now.getTimeInMillis() / 1000);
                            },
                            now.get(Calendar.HOUR_OF_DAY),
                            now.get(Calendar.MINUTE),
                            true);
                    tpd.show(getFragmentManager(), "请选择时间");
                    Utils.Log("A:" + i + "  B:" + i1 + "  C:" + i2);
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "请选择日期");
    }

    private void showAddressEdit() {
        new MaterialDialog.Builder(this)
                .title("输入约会地点")
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input("", tvAddress.getText(), new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        if (input.toString().trim().isEmpty()) {
                            JUtils.Toast("地址不能为空");
                            return;
                        }
                        tvAddress.setText(input);
                        getPresenter().setAddress(input.toString());
                    }
                }).show();
    }

    private void showGenderEdit() {
        new MaterialDialog.Builder(this)
                .title("选择性别要求")
                .items(Constant.GENDER_TYPE)
                .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        tvGender.setText(text);
                        getPresenter().setGender(which);
                        return true;
                    }
                })
                .positiveText("确定")
                .show();
    }

    private void showContentEditor(){
        new MaterialDialog.Builder(this)
                .title("输入备注")
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input("", tvContent.getText(), new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        tvContent.setText(input);
                        getPresenter().setContent(input.toString());
                    }
                }).show();
    }


}

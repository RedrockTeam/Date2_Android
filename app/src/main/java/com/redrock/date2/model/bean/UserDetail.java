package com.redrock.date2.model.bean;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
public class UserDetail extends User{
    private String realName;
    private String tag;
    private String school;
    private String charmValue;

    public UserDetail(String id, String face, String name, String sign, int gender, int age, boolean isCertification, String attentionCount, String fansCount, String realName, String tag, String school, String charmValue) {
        super(id, face, name, sign, gender, age, isCertification, attentionCount, fansCount);
        this.realName = realName;
        this.tag = tag;
        this.school = school;
        this.charmValue = charmValue;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCharmValue() {
        return charmValue;
    }

    public void setCharmValue(String charmValue) {
        this.charmValue = charmValue;
    }



}

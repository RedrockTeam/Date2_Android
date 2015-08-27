package com.redrock.date2.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
public class UserDetail extends User{
    @SerializedName("scan")
    private String attentionCount;
    @SerializedName("fans")
    private String fansCount;
    @SerializedName("realname")
    private String realName;
    @SerializedName("hobby")
    private String tag;
    @SerializedName("school")
    private String school;
    @SerializedName("charm")
    private String charmValue;

    public UserDetail(String id, String face, String name, String sign, int gender, int age, int role, String attentionCount, String fansCount, String charmValue, String realName, String tag, String school) {
        super(id, face, name, sign, gender, age, role);
        this.attentionCount = attentionCount;
        this.fansCount = fansCount;
        this.charmValue = charmValue;
        this.realName = realName;
        this.tag = tag;
        this.school = school;
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

    public String getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(String attentionCount) {
        this.attentionCount = attentionCount;
    }

    public String getFansCount() {
        return fansCount;
    }

    public void setFansCount(String fansCount) {
        this.fansCount = fansCount;
    }


}

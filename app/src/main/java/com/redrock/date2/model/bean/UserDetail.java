package com.redrock.date2.model.bean;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
public class UserDetail extends User{
    private String realName;
    private String tag;
    private String school;
    private String charmValue;
    private boolean isCertification;

    public UserDetail(String id,
                      String face,
                      String name,
                      String sign,
                      String attentionCount,
                      String fansCount,
                      String realName,
                      String tag,
                      String school,
                      String charmValue,
                      boolean isCertification) {
        super(id, face, name, sign, attentionCount, fansCount);
        this.realName = realName;
        this.tag = tag;
        this.school = school;
        this.charmValue = charmValue;
        this.isCertification = isCertification;
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

    public boolean isCertification() {
        return isCertification;
    }

    public void setIsCertification(boolean isCertification) {
        this.isCertification = isCertification;
    }


}

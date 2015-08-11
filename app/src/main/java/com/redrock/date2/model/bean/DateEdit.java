package com.redrock.date2.model.bean;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
public class DateEdit {
    private int style;
    private String title;
    private int memberCount;
    private int costType = -1;
    private long time;
    private String address;
    private int gender;
    private String content;

    public DateEdit(int style, String title, int memberCount, int costType, long time, String address, int gender, String content, String school) {
        this.style = style;
        this.title = title;
        this.memberCount = memberCount;
        this.costType = costType;
        this.time = time;
        this.address = address;
        this.gender = gender;
        this.content = content;
        this.school = school;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DateEdit() {
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public int getCostType() {
        return costType;
    }

    public void setCostType(int costType) {
        this.costType = costType;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    private String school;
}

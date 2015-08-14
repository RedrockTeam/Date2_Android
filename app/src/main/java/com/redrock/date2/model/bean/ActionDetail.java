package com.redrock.date2.model.bean;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
public class ActionDetail  extends Action{
    private long time;
    private String address;
    private String cost;
    private String content;
    private User[] member;
    private Comment[] comment;

    public ActionDetail(String image, String title, String tag, String memberCount, String praiseCount, String commentCount, long time, String address, String cost, String content, User[] member, Comment[] comment) {
        super(image, title, tag, memberCount, praiseCount, commentCount);
        this.time = time;
        this.address = address;
        this.cost = cost;
        this.content = content;
        this.member = member;
        this.comment = comment;
    }

    public Comment[] getComment() {

        return comment;
    }

    public void setComment(Comment[] comment) {
        this.comment = comment;
    }

    public User[] getMember() {
        return member;
    }

    public void setMember(User[] member) {
        this.member = member;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

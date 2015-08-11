package com.redrock.date2.model.bean;

/**
 * Created by Mr.Jude on 2015/8/9.
 */
public class DateDetail extends DateEdit {
    private long postTime;
    private User[] member;
    private User author;
    private Comment[] comments;

    public DateDetail(int style,
                      String title,
                      int memberCount,
                      int costType,
                      long time,
                      String address,
                      int gender,
                      String school,
                      String content,
                      long postTime,
                      User[] member,
                      User author,
                      Comment[] comments) {
        super(style, title, memberCount, costType, time, address, gender, content,school);
        this.postTime = postTime;
        this.member = member;
        this.author = author;
        this.comments = comments;
    }


    public long getPostTime() {
        return postTime;
    }

    public void setPostTime(long postTime) {
        this.postTime = postTime;
    }

    public User[] getMember() {
        return member;
    }

    public void setMember(User[] member) {
        this.member = member;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
}

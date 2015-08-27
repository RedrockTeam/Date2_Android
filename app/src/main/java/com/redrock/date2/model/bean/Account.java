package com.redrock.date2.model.bean;

/**
 * Created by Mr.Jude on 2015/8/22.
 */
public class Account {
    private String number;
    private String password;

    public Account(String number, String password) {
        this.number = number;
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

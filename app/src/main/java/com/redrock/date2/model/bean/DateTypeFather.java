package com.redrock.date2.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Mr.Jude on 2015/9/2.
 */
public class DateTypeFather extends DateType implements Serializable{
    @SerializedName("type_son")
    private DateType[] child;

    public DateTypeFather(String name, int id) {
        super(name, id);
    }

    public DateType[] getChild() {
        return child;
    }

    public void setChild(DateType[] child) {
        this.child = child;
    }
}

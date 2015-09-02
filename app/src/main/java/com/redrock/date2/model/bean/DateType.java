package com.redrock.date2.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Mr.Jude on 2015/8/8.
 */
public class DateType implements Serializable{
    @SerializedName("type_name")
    private String name;
    @SerializedName("type_id")
    private int id;

    public DateType(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.zdc.zl.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dachuan on 3/20/16.
 */
public class Guest {
    private String name;
    private int id;
    private String phone;
    private String email;
    private String message;
    private long number_of_guests;
    private String createTime;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public long getNumber_of_guests() {
        return number_of_guests;
    }

    public void setName(String name) {
        this.name = name;
        this.id = name.hashCode();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        this.createTime = sdf.format(now);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNumber_of_guests(long number_of_guests) {
        this.number_of_guests = number_of_guests;
    }

    public int getId() {
        return id;
    }

    public String getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", number_of_guests=" + number_of_guests +
                '}';
    }
}

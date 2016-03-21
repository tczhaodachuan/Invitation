package com.zdc.zl.model;

/**
 * Created by dachuan on 3/20/16.
 */
public class Guest {
    private String name;
    private String phone;
    private String email;
    private String message;
    private long number_of_guests;

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

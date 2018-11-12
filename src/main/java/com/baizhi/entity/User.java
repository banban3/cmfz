package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private String id;
    private String name;
    private String phone;
    private String password;
    private String salt;
    private String img_url;
    private String fname;
    private String sex;
    private String addre;
    private String signature;
    private String stat;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date c_date;

    public User() {
    }

    public User(String id, String name, String phone, String password, String salt, String img_url, String fname, String sex, String addre, String signature, String stat, Date c_date) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.salt = salt;
        this.img_url = img_url;
        this.fname = fname;
        this.sex = sex;
        this.addre = addre;
        this.signature = signature;
        this.stat = stat;
        this.c_date = c_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddre() {
        return addre;
    }

    public void setAddre(String addre) {
        this.addre = addre;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Date getC_date() {
        return c_date;
    }

    public void setC_date(Date c_date) {
        this.c_date = c_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", img_url='" + img_url + '\'' +
                ", fname='" + fname + '\'' +
                ", sex='" + sex + '\'' +
                ", addre='" + addre + '\'' +
                ", signature='" + signature + '\'' +
                ", stat='" + stat + '\'' +
                ", c_date=" + c_date +
                '}';
    }
}

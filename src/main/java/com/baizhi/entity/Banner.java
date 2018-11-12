package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Banner {
    private String id;
    private String title;
    private String img_url;
    private String des;
    private String sta;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date i_date;

    public Banner() {
    }

    public Banner(String id, String title, String img_url, String des, String sta, Date i_date) {
        this.id = id;
        this.title = title;
        this.img_url = img_url;
        this.des = des;
        this.sta = sta;
        this.i_date = i_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getSta() {
        return sta;
    }

    public void setSta(String sta) {
        this.sta = sta;
    }

    public Date getI_date() {
        return i_date;
    }

    public void setI_date(Date i_date) {
        this.i_date = i_date;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", img_url='" + img_url + '\'' +
                ", des='" + des + '\'' +
                ", sta='" + sta + '\'' +
                ", i_date=" + i_date +
                '}';
    }
}

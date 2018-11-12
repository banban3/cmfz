package com.baizhi.entity;


import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Chapter {
    private String id;
    private String name;
    private Double size;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pub_time;
    private String downpath;
    private String downloadtime;
    private String a_id;

    public Chapter() {
    }

    public Chapter(String id, String name, Double size, Date pub_time, String downpath, String downloadtime, String a_id) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.pub_time = pub_time;
        this.downpath = downpath;
        this.downloadtime = downloadtime;
        this.a_id = a_id;
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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Date getPub_time() {
        return pub_time;
    }

    public void setPub_time(Date pub_time) {
        this.pub_time = pub_time;
    }

    public String getDownpath() {
        return downpath;
    }

    public void setDownpath(String downpath) {
        this.downpath = downpath;
    }

    public String getDownloadtime() {
        return downloadtime;
    }

    public void setDownloadtime(String downloadtime) {
        this.downloadtime = downloadtime;
    }

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", pub_time=" + pub_time +
                ", downpath='" + downpath + '\'' +
                ", downloadtime='" + downloadtime + '\'' +
                ", a_id='" + a_id + '\'' +
                '}';
    }
}

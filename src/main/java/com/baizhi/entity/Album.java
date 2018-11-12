package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album {
    private String id;//
    private String name;//名称
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pub_date;//时间
    private Integer n_count;//数量
    private String img_url;//头像
    private Integer star;//星际
    private String author;//作者
    private String broadcast;//播音
    private String context;//简介
    private List<Chapter> children;

    public Album() {
    }

    public Album(String id, String name, Date pub_date, Integer n_count, String img_url, Integer star, String author, String broadcast, String context, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.pub_date = pub_date;
        this.n_count = n_count;
        this.img_url = img_url;
        this.star = star;
        this.author = author;
        this.broadcast = broadcast;
        this.context = context;
        this.children = children;
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

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public Integer getN_count() {
        return n_count;
    }

    public void setN_count(Integer n_count) {
        this.n_count = n_count;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pub_date=" + pub_date +
                ", n_count=" + n_count +
                ", img_url='" + img_url + '\'' +
                ", star=" + star +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", context='" + context + '\'' +
                ", children=" + children +
                '}';
    }
}

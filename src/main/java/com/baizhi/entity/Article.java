package com.baizhi.entity;

import java.util.Date;
import java.util.List;

public class Article {
    private String id;
    private String title;
    private String c_img;
    private Date pub_date;
    private String content;
    private String fid;
    private Teach teach;

    public Article() {
    }

    public Article(String id, String title, String c_img, Date pub_date, String content, String fid, Teach teach) {
        this.id = id;
        this.title = title;
        this.c_img = c_img;
        this.pub_date = pub_date;
        this.content = content;
        this.fid = fid;
        this.teach = teach;
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

    public String getC_img() {
        return c_img;
    }

    public void setC_img(String c_img) {
        this.c_img = c_img;
    }

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public Teach getTeach() {
        return teach;
    }

    public void setTeach(Teach teach) {
        this.teach = teach;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", c_img='" + c_img + '\'' +
                ", pub_date=" + pub_date +
                ", content='" + content + '\'' +
                ", fid='" + fid + '\'' +
                ", teach=" + teach +
                '}';
    }
}

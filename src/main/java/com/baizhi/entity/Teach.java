package com.baizhi.entity;

public class Teach {
    private String id;
    private String name;
    private String head_img;
    private String sex;

    public Teach() {
    }

    public Teach(String id, String name, String head_img, String sex) {
        this.id = id;
        this.name = name;
        this.head_img = head_img;
        this.sex = sex;
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

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Teach{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", head_img='" + head_img + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

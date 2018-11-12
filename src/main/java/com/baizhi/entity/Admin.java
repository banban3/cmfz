package com.baizhi.entity;

public class Admin {
    private String id;
    private String name;
    private String password;
    private String limits;//管理员权限

    public Admin() {
    }

    public Admin(String id, String name, String password, String limits) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.limits = limits;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLimits() {
        return limits;
    }

    public void setLimits(String limits) {
        this.limits = limits;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", limits='" + limits + '\'' +
                '}';
    }
}


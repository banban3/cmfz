package com.baizhi.entity;

public class Course {
    private String id;
    private String homework;
    private String score;
    private String user_id;
    private Counter counter;

    public Course() {
    }

    public Course(String id, String homework, String score, String user_id, Counter counter) {
        this.id = id;
        this.homework = homework;
        this.score = score;
        this.user_id = user_id;
        this.counter = counter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }
    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", homework='" + homework + '\'' +
                ", score='" + score + '\'' +
                ", user_id='" + user_id + '\'' +
                ", counter=" + counter +
                '}';
    }
}

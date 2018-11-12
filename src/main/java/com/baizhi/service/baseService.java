package com.baizhi.service;

import java.util.List;

public interface baseService<T> {
    void add(T t);
    void motify(T t);
    void remove(T t);
    T findOne(String id);
    List<T> findAll();
    List<T> findByPage(Integer page, Integer rows);
    Long findTotal();
}

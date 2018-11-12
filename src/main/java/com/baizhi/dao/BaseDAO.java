package com.baizhi.dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<T> {
    void insert(T t);

    void update(T t);

    void delete(String id);

    T queryOne(String obj);

    List<T> queryAll();

    //展示分页的数据，  参数1：起始条数 参数2：每页显示的记录
    List<T> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //查询总条数
    Long findTotals();
}

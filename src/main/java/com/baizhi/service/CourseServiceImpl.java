package com.baizhi.service;

import com.baizhi.dao.CourseDAO;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDAO courseDAO;
    @Override
    public void add(Course course) {
        course.setId(UUID.randomUUID().toString());
        course.setScore("必修");
        courseDAO.insert(course);
    }

    @Override
    public void motify(Course course) {
       courseDAO.update(course);
    }

    @Override
    public void remove(Course course) {
        courseDAO.delete(course.getId());
    }

    @Override
    public Course findOne(String id) {
        return courseDAO.queryOne(id);
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.queryAll();
    }

    @Override
    public List<Course> findByPage(Integer page, Integer rows) {
        int star=(page-1)*rows;
        return courseDAO.findByPage(star,rows);
    }

    @Override
    public Long findTotal() {
        return courseDAO.findTotals();
    }
}

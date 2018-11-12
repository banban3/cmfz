package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            Long total = courseService.findTotal();
            List<Course> all = courseService.findByPage(page,rows);

            results.put("total",total);
            results.put("rows",all);
            results.put("suc",true);
            results.put("msg","成功");
        }catch (Exception e){
            e.printStackTrace();
            results.put("suc",false);
            results.put("msg","失败");
        }
        return results;
    }

    @RequestMapping("/save")
    public @ResponseBody Map<String,Object> add(Course course){
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            courseService.add(course);
            results.put("suc",true);
            results.put("msg","添加成功");

        } catch (Exception e) {
            e.printStackTrace();
            results.put("suc",false);
            results.put("msg","添加失败");
        }

        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody
    Course findOne(String id, HttpServletRequest request) {
        try {
            Course course = courseService.findOne(id);
            // String realPath = request.getSession().getServletContext().getRealPath("/back/img/banner");
            return course;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}

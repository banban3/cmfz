package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.entity.Teach;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            Long total = articleService.findTotal();
            List<Article> all = articleService.findByPage(page,rows);

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
}

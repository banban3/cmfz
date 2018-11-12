package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.entity.Teach;
import com.baizhi.service.ChapterService;
import com.baizhi.util.FileUtil;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    String address="/back/chapter/context/";

    @RequestMapping("/save")
    public @ResponseBody
    Map<String,Object> add(Chapter chapter, HttpServletRequest request, MultipartFile file){
        Map<String, Object> results = new HashMap<String, Object>();
        try {

            String fileName = FileUtil.saveFile(file, address, request);
            String times = FileUtil.audioLength(fileName, request);
            Double size = FileUtil.audioSize(fileName, request);

            //System.out.println(times);
            //System.out.println(size);

            chapter.setDownpath(fileName);
            chapter.setDownloadtime(times);
            chapter.setSize(size);
            chapterService.add(chapter);
            results.put("suc",true);
            results.put("msg","添加成功");

        } catch (Exception e) {
            e.printStackTrace();
            results.put("suc",false);
            results.put("msg","添加失败");
        }

        return results;
    }

    @RequestMapping("/download")
    public void download(String openStyle, String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //打开对应文件夹
        String realPath=request.getSession().getServletContext().getRealPath(fileName);
        //以文件输出流读取文件
        File file = new File(realPath);
        FileInputStream fis = new FileInputStream(file);
        //设置响应头
        response.setHeader("content-disposition", openStyle+";fileName="+ URLEncoder.encode(fileName, "UTF-8"));
        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(fis,os);
        IOUtils.closeQuietly(fis);
        IOUtils.closeQuietly(os);
    }
}

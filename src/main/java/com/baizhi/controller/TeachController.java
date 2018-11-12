package com.baizhi.controller;

import com.baizhi.entity.Teach;
import com.baizhi.service.TeachService;
import com.baizhi.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teach")
public class TeachController {
    @Autowired
    private TeachService teachService;

    String address="/back/img/teach/";

    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> add(Teach teach, HttpServletRequest request, MultipartFile tea_img){
        Map<String, Object> results = new HashMap<String, Object>();
        try {

            String fileName = FileUtil.saveFile(tea_img, address, request);
            teach.setHead_img(fileName);

            teachService.add(teach);
            results.put("suc",true);
            results.put("msg","添加成功");

        } catch (Exception e) {
            e.printStackTrace();
            results.put("suc",false);
            results.put("msg","添加失败");
        }

        return results;
    }

    @RequestMapping("/delete")
    public @ResponseBody Map<String,Object> delete(String id, HttpServletRequest request){
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            Teach tea = teachService.findOne(id);
            /*String realPath=request.getSession().getServletContext().getRealPath(tea.getHead_img());
            File file = new File(realPath);
            file.delete();*/
            FileUtil.deleteFile(tea.getHead_img(),request);

            teachService.remove(tea);
            results.put("suc",true);

        } catch (Exception e) {
            e.printStackTrace();
            results.put("suc",false);
        }

        return results;
    }

    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(String id,Teach teach, HttpServletRequest request, MultipartFile tea_img){
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            //删除原有图片
            Teach tea = teachService.findOne(id);
           /* String realPath=request.getSession().getServletContext().getRealPath(tea.getHead_img());
            File file = new File(realPath);
            file.delete();*/
            //将新加的图片添加到数据库
            /*String realname = tea_img.getOriginalFilename();
            //String realPath = request.getRealPath("/back/img");
            String realPath2 = request.getSession().getServletContext().getRealPath("/back/img/teach");
            tea_img.transferTo(new File(realPath2, realname));
            teach.setHead_img("/back/img/teach/"+realname);*/
            //System.out.println(realname);
            if(tea_img!=null){
                FileUtil.udpateFile(tea_img,tea.getHead_img(),address,request);
                teachService.motify(teach);
                results.put("suc",true);
            }else{
                throw new RuntimeException("文件不能为空！！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            results.put("suc",false);
        }

        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody
    Teach findOne(String id,HttpServletRequest request) {
        try {
            //Banner banner = bannerService.findOne(id);
            Teach teach = teachService.findOne(id);
            //String realPath = request.getSession().getServletContext().getRealPath("/back/img/teach");

            return teach;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page, Integer rows){
        Map<String, Object> results = new HashMap<String, Object>();
            try {
                Long total = teachService.findTotal();
                List<Teach> all = teachService.findByPage(page,rows);

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

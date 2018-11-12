package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> add(Banner banner,HttpServletRequest request, MultipartFile bn){
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            String realname = bn.getOriginalFilename();
            //String realPath = request.getRealPath("/back/img");
            String realPath = request.getSession().getServletContext().getRealPath("/back/img/banner");
            //System.out.println(realPath);

            bn.transferTo(new File(realPath, realname));

            banner.setImg_url("/back/img/banner/"+realname);
            //System.out.println(realname);
            bannerService.add(banner);

            results.put("suc",true);
            results.put("msg","添加图片成功");

        } catch (Exception e) {
            e.printStackTrace();
            results.put("suc",false);
            results.put("msg","添加图片失败");
        }

        return results;
    }

    @RequestMapping("/delete")
    public @ResponseBody Map<String, Object> delete(String id,HttpServletRequest request){
        Map<String, Object> results = new HashMap<String,Object>();
        try {
            Banner ban = bannerService.findOne(id);
            //System.out.println(ban);

            String realPath = request.getSession().getServletContext().getRealPath(ban.getImg_url());
            File file = new File(realPath);
            file.delete();

            bannerService.remove(ban);
            results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(String id,Banner banner,HttpServletRequest request, MultipartFile bn) {
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            //删除原来的图片
            Banner ban = bannerService.findOne(id);
            String realPath = request.getSession().getServletContext().getRealPath(ban.getImg_url());
            File file = new File(realPath);
            file.delete();

            //将新加的图片添加到数据库
            String realname = bn.getOriginalFilename();
            //String realPath = request.getRealPath("/back/img");
            String realPath2 = request.getSession().getServletContext().getRealPath("/back/img/banner");

            bn.transferTo(new File(realPath2, realname));

            banner.setImg_url("/back/img/banner/"+realname);
            //System.out.println(realname);
            bannerService.motify(banner);

            results.put("suc",true);
            results.put("msg","修改图片成功");

        } catch (Exception e) {
            e.printStackTrace();
            results.put("suc",false);
            results.put("msg","修改图片失败");
        }

        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody
    Banner findOne(String id,HttpServletRequest request) {
        try {
           Banner banner = bannerService.findOne(id);
          // String realPath = request.getSession().getServletContext().getRealPath("/back/img/banner");
            return banner;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String, Object> findAll() {
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            List<Banner> all = bannerService.findAll();

            results.put("rows", all);
            results.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success", false);
            results.put("message", e.getMessage());
        }
        return results;
    }
}

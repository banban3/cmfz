package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Teach;
import com.baizhi.service.AlbumService;
import com.baizhi.util.FileUtil;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;
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
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    String address="/back/album/context/";

    @RequestMapping("/findPage")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            Long total = albumService.findTotal();
            System.out.println(total);
            List<Album> all = albumService.findByPage(page, rows);

            for (Album album : all) {
                System.out.println(album);
            }

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
    public @ResponseBody
    Map<String,Object> save(Album album, HttpServletRequest request,MultipartFile alb_img){

        Map<String, Object> results = new HashMap<String, Object>();
        try {
            request.setCharacterEncoding("UTF-8");
            String path = FileUtil.saveFile(alb_img, address, request);
            album.setImg_url(path);
            albumService.add(album);
            results.put("suc",true);
            results.put("msg","成功");
        }catch (Exception e){
            e.printStackTrace();
            results.put("suc",false);
            results.put("msg","失败");
        }
        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody
    Album findOne(String id){
        Album album = albumService.findOne(id);

        return album;
    }
}

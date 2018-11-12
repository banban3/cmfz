package com.baizhi.controller;

import com.baizhi.entity.Teach;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.FileUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    String address="/back/user/img/";

    @RequestMapping("/add")
    public @ResponseBody
    Map<String,Object> add(User user, HttpServletRequest request, MultipartFile file){
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            String fileName = FileUtil.saveFile(file, address, request);
            user.setImg_url(fileName);

            userService.add(user);
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
    public @ResponseBody
    Map<String,Object> delete(String id, HttpServletRequest request){
        Map<String, Object> results = new HashMap<String, Object>();
        try {

            User user = userService.findOne(id);
            FileUtil.deleteFile(user.getImg_url(),request);

            userService.add(user);
            results.put("suc",true);
            results.put("msg","添加成功");

        } catch (Exception e) {
            e.printStackTrace();
            results.put("suc",false);
            results.put("msg","添加失败");
        }

        return results;
    }
    @RequestMapping("/updateStat")
    public @ResponseBody
    Map<String,Object> update(String id,String sta,HttpServletRequest request){
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            User user = userService.findOne(id);
            user.setStat(sta);
            userService.motifyStat(user);
            results.put("suc",true);
            results.put("msg","成功");
        } catch (Exception e) {
            e.printStackTrace();
            results.put("suc",false);
            results.put("msg","失败");
        }

        return results;
    }

    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page, Integer rows){
        Map<String, Object> results = new HashMap<String, Object>();
        try {
            Long total =userService.findTotal();
            List<User> all = userService.findByPage(page,rows);

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

    @RequestMapping("/login")
    public String login(String id,String password){

            User user = userService.findOne(id);
            String salt = user.getSalt();
            String pwd = DigestUtils.md5Hex(password + "" + salt);
            if(pwd.equals(user.getPassword())&&user.getStat().equals("正常")){
                return "redirect:/back/main/main.jsp";
            }else {
                return "redirect:/index.jsp";
            }
    }

    @RequestMapping("/uppwd")
    public String uppwd(String id,String password,String password2){
        User user = userService.findOne(id);
        String salt = user.getSalt();
        String pwd = DigestUtils.md5Hex(password + "" + salt);
        if(pwd.equals(user.getPassword())){
            String pwd2 = DigestUtils.md5Hex(password2 + "" + user.getSalt());
            user.setPassword(pwd2);
            userService.motify(user);
            return "redirect:/back/main/main.jsp";
        }else {
            return "redirect:/index.jsp";
        }
    }


}

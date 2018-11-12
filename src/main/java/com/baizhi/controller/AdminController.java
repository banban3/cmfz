package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Admin admin, String code, HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();
        Admin login = adminService.login(admin);

        String code2=(String) session.getAttribute("validationCode");

        if (login != null&&code.equals(code2)){
            session.setAttribute("success", "success");
            session.setAttribute("admin", login);
            return "redirect:/back/main/main.jsp";
        }else return "redirect:/back/login.jsp";

    }

    @RequestMapping("/quit")
    public String quit(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("admin",null);
        return "redirect:/back/login.jsp";
    }

    @RequestMapping("/change")
    public  @ResponseBody
    Map<String, Object> update(String password,String password2,HttpServletRequest httpServletRequest) {

        Map<String, Object> results = new HashMap<String,Object>();

        HttpSession session = httpServletRequest.getSession();
        Admin admin=(Admin) session.getAttribute("admin");
        //System.out.println(admin+"1111");
        //System.out.println(password2+"222222");
        try {
            if (admin.getPassword().equals(password)){
                admin.setPassword(password2);
                adminService.motify(admin);
                results.put("success",true);
                session.setAttribute("admin",null);
                results.put("msg","密码修改成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
            results.put("msg","密码修改失败s");
        }
        return results;
    }

}

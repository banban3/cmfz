package com.test;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class aaserTest extends baseTest{
    @Autowired
    private AdminService adminService;

    Admin user=new Admin("2","xiao","123","0");

    @Test
    public void login(){
        Admin login = adminService.login(user);
        System.out.println(login);
    }
}

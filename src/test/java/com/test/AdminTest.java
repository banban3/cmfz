package com.test;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminTest extends baseTest {
    @Autowired
    private AdminService adminService;
   @Test
    public void update(){
       Admin admin=new Admin("1","qwe","qweqwe","1");
        adminService.motify(admin);
    }
}

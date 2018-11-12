package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService extends baseService<Admin>{
    public Admin login(Admin admin);
}

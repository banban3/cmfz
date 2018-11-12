package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class AdminServiceImpl implements AdminService{


    @Autowired
    private AdminDAO adminDAO;
    @Override
    public Long findTotal() {
        return adminDAO.findTotals();
    }
    @Override
    public void add(Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        adminDAO.insert(admin);
    }

    @Override
    public void motify(Admin admin) {
        adminDAO.update(admin);
    }

    @Override
    public void remove(Admin admin) {
        adminDAO.delete(admin.getId());
    }

    @Override
    public Admin findOne(String name) {
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public List<Admin> findByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public Admin login(Admin admin) {
        Admin userselect = adminDAO.queryOne(admin.getName());
        if(userselect!=null&&userselect.getName().equals(admin.getName())&&userselect.getPassword().equals(admin.getPassword())){
            return userselect;
        }else return null;
    }
}

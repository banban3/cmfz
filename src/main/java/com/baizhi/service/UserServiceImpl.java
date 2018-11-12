package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.util.MD5Util;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;


import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public void add(User user) {
        String phone = user.getPhone();
        user.setId(phone);
        String salt = MD5Util.getSalt();
        String pwd = DigestUtils.md5Hex(user.getPassword() + "" + salt);
        user.setSalt(salt);

        user.setPassword(pwd);
        userDAO.insert(user);
    }

    @Override
    public void motify(User user) {
        userDAO.update(user);
    }

    @Override
    public void motifyStat(User user) {
        userDAO.upStat(user);
    }

    @Override
    public void remove(User user) {
        userDAO.delete(user.getId());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findOne(String id) {
        return userDAO.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findAll() {
        List<User> users = userDAO.queryAll();
        return users;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return userDAO.findByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotal() {
        return userDAO.findTotals();
    }
}

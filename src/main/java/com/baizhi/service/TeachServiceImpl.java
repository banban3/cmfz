package com.baizhi.service;

import com.baizhi.dao.TeachDAO;
import com.baizhi.entity.Teach;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TeachServiceImpl implements TeachService {


    @Autowired
    private TeachDAO teachDAO;

    @Override
    public Long findTotal() {
        return teachDAO.findTotals();
    }
    @Override
    public void add(Teach teach) {
        teach.setId(UUID.randomUUID().toString());
        teachDAO.insert(teach);
    }

    @Override
    public void motify(Teach teach) {
        teachDAO.update(teach);
    }

    @Override
    public void remove(Teach teach) {
        teachDAO.delete(teach.getId());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Teach findOne(String id) {
        Teach teach = teachDAO.queryOne(id);
        return teach;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Teach> findAll() {
        List<Teach> teaches = teachDAO.queryAll();
        return teaches;
        /*Integer page, Integer rows*/
    }
    @Override
    //支持事物
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Teach> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return teachDAO.findByPage(start,rows);
    }
}

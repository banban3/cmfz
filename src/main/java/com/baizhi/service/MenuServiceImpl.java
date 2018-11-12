package com.baizhi.service;

import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {


 @Autowired
    private MenuDAO menuDAO;

    @Override
    public Long findTotal() {
        return menuDAO.findTotals();
    }
    @Override
    public void add(Menu menu) {

    }

    @Override
    public void motify(Menu menu) {

    }

    @Override
    public void remove(Menu menu) {

    }

    @Override
    public Menu findOne(String name) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Menu> findAll() {
        List<Menu> menus = menuDAO.queryAll();
        return menus;
    }

 @Override
 public List<Menu> findByPage(Integer page, Integer rows) {
  return null;
 }
}

package com.baizhi.service;

import com.baizhi.dao.BannerDAO;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {


    @Autowired
   private BannerDAO bannerDAO;
    @Override
    public Long findTotal() {
        return bannerDAO.findTotals();
    }
    @Override
    public void add(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        banner.setI_date(new Date());
        bannerDAO.insert(banner);
    }

    @Override
    public void motify(Banner banner) {
        bannerDAO.update(banner);
    }

    @Override
    public void remove(Banner banner) {
        bannerDAO.delete(banner.getId());
    }

    @Override
    public Banner findOne(String id) {
        return bannerDAO.queryOne(id);
    }

    @Override
    public List<Banner> findByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> findAll() {
        return bannerDAO.queryAll();
    }
}

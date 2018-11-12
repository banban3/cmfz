package com.baizhi.service;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumDAO albumDAO;
    @Autowired
    private ChapterDAO chapterDAO;

    @Override
    public void add(Album album) {
        album.setId(UUID.randomUUID().toString());

        int count = (int) chapterDAO.acount(album.getId());
        album.setN_count(count);

        albumDAO.insert(album);
    }

    @Override
    public void motify(Album album) {
        albumDAO.update(album);
    }

    @Override
    public void remove(Album album) {
        albumDAO.delete(album.getId());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Album findOne(String id) {
        return albumDAO.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findAll() {
        return albumDAO.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return albumDAO.findByPage(start,rows);
    }

    @Override
    public Long findTotal() {
        return albumDAO.findTotals();
    }
}

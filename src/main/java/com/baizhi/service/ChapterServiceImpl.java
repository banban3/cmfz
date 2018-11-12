package com.baizhi.service;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {


    @Autowired
    private ChapterDAO chapterDAO;
    @Autowired
    private AlbumDAO albumDAO;

    @Override
    public void add(Chapter chapter) {
        String id = chapter.getId();

        Album album = albumDAO.queryOne(id);
        int acount = (int)chapterDAO.acount(id);
        album.setN_count(acount+1);

        chapter.setA_id(id);

        chapter.setId(UUID.randomUUID().toString());
        chapterDAO.insert(chapter);
    }

    @Override
    public void motify(Chapter chapter) {
        chapterDAO.update(chapter);
    }

    @Override
    public void remove(Chapter chapter) {
        chapterDAO.delete(chapter.getId());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Chapter findOne(String id) {
        return chapterDAO.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Chapter> findAll() {
        return chapterDAO.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Chapter> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return chapterDAO.findByPage(start,rows);
    }

    @Override
    public Long findTotal() {
        return chapterDAO.findTotals();
    }

    @Override
    public long allcount(String a_id) {
        return chapterDAO.acount(a_id);
    }
}

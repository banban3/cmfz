package com.baizhi.service;

import com.baizhi.dao.ArticleDAO;
import com.baizhi.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.soap.Addressing;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDAO articleDAO;
    @Override
    public void add(Article article) {
        article.setId(UUID.randomUUID().toString());
        articleDAO.insert(article);
    }

    @Override
    public void motify(Article article) {
        articleDAO.update(article);
    }

    @Override
    public void remove(Article article) {
        articleDAO.delete(article.getId());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Article findOne(String id) {
        return articleDAO.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> findAll() {
        return articleDAO.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> findByPage(Integer page, Integer rows) {
        int star=(page-1)*rows;
        return articleDAO.findByPage(star,rows);
    }

    @Override
    public Long findTotal() {
        return articleDAO.findTotals();
    }
}

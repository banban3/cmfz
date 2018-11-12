package com.test;

import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class TestChapter extends baseTest {
    @Autowired
    private ChapterDAO chapterDAO;
    @Test
    public void query(){
        Chapter chapter = new Chapter("102","aaa",12.55,new Date(),"/baj/cd/dd.txt","2分20","1");
        chapterDAO.insert(chapter);
    }
}

package com.test;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlbumTest extends baseTest {
    @Autowired
    private AlbumService albumService;
   @Test
    public void query(){
        int page=1;
        int rows=10;
        List<Album> byPage = albumService.findByPage(page, rows);
        for (Album pa:byPage){
            System.out.println(pa);
        }
    }
}

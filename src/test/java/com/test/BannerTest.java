package com.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class BannerTest extends baseTest {
    @Autowired
    private BannerService bannerService;

    @Test
    public void testinsert(){
        Banner banner = new Banner("4","藏区一角","/back/img/4.gif","aa","1",new Date());
        bannerService.add(banner);
    }
}

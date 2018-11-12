package com.test;

import com.baizhi.entity.Teach;
import com.baizhi.service.TeachService;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeachTest extends baseTest {

    @Autowired
    private TeachService teachService;

    @Test
    public void query(){
        List<Teach> all = teachService.findAll();
        for(Teach tea:all){
            System.out.println(tea);
        }
    }
}

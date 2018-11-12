package com.baizhi.service;

import com.baizhi.entity.Chapter;

public interface ChapterService extends baseService<Chapter> {
    long allcount(String a_id);
}

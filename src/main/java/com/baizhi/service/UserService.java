package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService extends baseService<User> {
    void motifyStat(User user);
}

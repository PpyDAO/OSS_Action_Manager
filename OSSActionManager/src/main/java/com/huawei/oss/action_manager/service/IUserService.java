package com.huawei.oss.action_manager.service;

import com.huawei.oss.action_manager.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> findByUsername(String username);
}

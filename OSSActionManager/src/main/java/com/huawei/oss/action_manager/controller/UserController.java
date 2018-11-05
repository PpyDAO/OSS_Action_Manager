package com.huawei.oss.action_manager.controller;

import com.huawei.oss.action_manager.pojo.User;
import com.huawei.oss.action_manager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/findByUsername")
    public List<User> findByUsername(String username) {
        return userService.findByUsername(username);
    }
}

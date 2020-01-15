package com.alibaba.controller;

import com.alibaba.bean.ResultUser;
import com.alibaba.bean.User;
import com.alibaba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param user 参数封装
     * @return ResultUser
     */
    @PostMapping(value = "/regist")
    public ResultUser regist(User user){
        return userService.regist(user);
    }

    /**
     * 登录
     * @param user 参数封装
     * @return ResultUser
     */
    @PostMapping(value = "/login")
    public ResultUser login(User user){
        return userService.login(user);
    }

    /**
     * 验证
     * @param user 参数封装
     * @return ResultUser
     */
    @PostMapping(value = "/authority")
    public ResultUser changenum(User user){
        return userService.changenum(user);
    }
}


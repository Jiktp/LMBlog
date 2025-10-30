package com.yutou.controller;

import com.yutou.domain.ResponseResult;
import com.yutou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     * @return
     */
    @GetMapping("/userInfo")
    public ResponseResult userInfo() {
       return userService.userInfo();
    }
}

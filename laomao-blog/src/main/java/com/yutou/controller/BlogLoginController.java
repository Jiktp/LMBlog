package com.yutou.controller;

import com.yutou.domain.ResponseResult;
import com.yutou.domain.entity.User;
import com.yutou.enums.AppHttpCodeEnum;
import com.yutou.exception.SystemException;
import com.yutou.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogLoginController {

    @Autowired
    //BlogLoginService是我们在service目录写的接口
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    //ResponseResult是我们在laomao-framework工程里面写的实体类
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }
    @PostMapping("/loginout")
    public ResponseResult logout(){
        return blogLoginService.loginout();
    }

}

package com.yutou.service;

import com.yutou.domain.ResponseResult;
import com.yutou.domain.entity.User;

public interface BlogLoginService {


    ResponseResult login(User user);

    ResponseResult loginout();
}

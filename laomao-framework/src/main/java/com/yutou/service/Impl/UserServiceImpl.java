package com.yutou.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yutou.domain.entity.User;
import com.yutou.mapper.UserMapper;
import com.yutou.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2025-10-28 14:50:25
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}


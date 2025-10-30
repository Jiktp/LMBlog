package com.yutou.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yutou.domain.ResponseResult;
import com.yutou.domain.entity.User;
import com.yutou.domain.vo.UserInfoVo;
import com.yutou.mapper.UserMapper;
import com.yutou.service.UserService;
import com.yutou.utils.BeanCopyUtils;
import com.yutou.utils.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2025-10-28 14:50:25
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 获取当前用户的信息
     * @return
     */
    @Override
    public ResponseResult userInfo() {
        //获取当前用户的id
        Long userId = SecurityUtils.getUserId();
        //根据用户的id查询用户信息
        User user = getById(userId);
        //封装成userInfoVo
        UserInfoVo vo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }
}


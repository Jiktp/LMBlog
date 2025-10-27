package com.yutou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yutou.domain.ResponseResult;
import com.yutou.domain.entity.Link;

/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2025-10-27 14:47:38
 */
public interface LinkService extends IService<Link> {
    /**
     * 查询友链
     * @return
     */
    ResponseResult getAllLink();
}


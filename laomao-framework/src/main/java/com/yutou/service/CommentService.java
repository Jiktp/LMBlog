package com.yutou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yutou.domain.ResponseResult;
import com.yutou.domain.entity.Comment;

/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2025-10-28 14:11:18
 */
public interface CommentService extends IService<Comment> {

    /**
     * 评论
     * @param articleId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize);
}


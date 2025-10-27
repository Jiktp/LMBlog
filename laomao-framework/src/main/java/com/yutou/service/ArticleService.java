package com.yutou.service;

import com.yutou.domain.ResponseResult;
import com.yutou.domain.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ArticleService extends IService<Article> {

    /**
     * 热门文章列表
     * @return
     */
    ResponseResult hotArticleList();

    /**
     * 文章分页查询
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @return
     */
    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    /**
     * 获取文章详情
     * @param id
     * @return
     */
    ResponseResult getArticleDetail(Integer id);
}

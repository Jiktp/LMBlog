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
}

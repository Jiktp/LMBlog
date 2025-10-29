package com.yutou.controller;

import com.yutou.domain.ResponseResult;
import com.yutou.domain.entity.Article;
import com.yutou.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

//    @GetMapping("/list")
//    public List<Article> test(){
//        return articleService.list();
//    }

    /**
     * 热门文章列表
     * @return
     */
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList() {
        log.info("hotArticleList:");
        //查询热门文章 封装成ResponseResult返回
        ResponseResult result = articleService.hotArticleList();
        return result;
    }

    /**
     * 文章页面显示
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @return
     */
    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        log.info("articleList:",pageNum,pageSize,categoryId);
        return articleService.articleList(pageNum,pageSize,categoryId);
    }

    /**
     * 获取文章详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Integer id) {
        log.info("getArticleDetail:",id);
        return articleService.getArticleDetail(id);
    }
}

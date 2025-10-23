package com.yutou.service.Impl;

import com.yutou.domain.entity.Article;
import com.yutou.mapper.ArticleMapper;
import com.yutou.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}

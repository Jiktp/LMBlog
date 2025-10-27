package com.yutou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yutou.domain.ResponseResult;
import com.yutou.domain.entity.Category;

/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2025-10-27 10:50:10
 */
public interface CategoryService extends IService<Category> {


    ResponseResult getCategoryList();
}


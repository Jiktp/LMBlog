package com.yutou.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailVo {

    private Long id;
    //标题
    private String title;
    //文章摘要
    private String summary;
    //分类名称
    private String categoryName;
    //分类id
    private Long categoryId;
    //缩略图
    private String thumbnail;
    //内容
    private String content;

    //访问量
    private Long viewCount;

    private Date createTime;
}

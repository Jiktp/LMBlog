package com.yutou.contains;

public class SystemContains {
    /**
     * 文章是正常发布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;
    /**
     * 文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;
    /**
     * 热门文章页数
     */
    public static final int ARTICLE_PAGE_LIST = 1;
    /**
     * 热门文章展示条数
     */
    public static final int ARTICLE_LIST_PAGE = 10;

    public static final String  STATUS_NORMAL = "0";
    /**
     * 友链审核通过状态
     */
    public static final String LINK_STATUS_NORMAL = "0";

    /**
     * 查看根评论
     */
    public static final int ROOT_STATUS_NORMAL = -1;

    /**
     * 评论类型为；文章
     */
    public static final String ARTICLE_COMMENT = "0";

    /**
     * 评论类型为友链
     */
    public static final String LINK_COMMENT = "1";
}

package com.yutou.controller;

import com.yutou.contains.SystemContains;
import com.yutou.domain.ResponseResult;
import com.yutou.domain.entity.Comment;
import com.yutou.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 文章评论
     * @param articleId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("commentList")
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize){
        return commentService.commentList(SystemContains.ARTICLE_COMMENT,articleId,pageNum,pageSize);
    }

    @PostMapping
    public ResponseResult addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    /**
     * 友链评论
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/lickCommentList")
    public ResponseResult linkCommentList(Integer pageNum, Integer pageSize){
        return commentService.commentList(SystemContains.LINK_COMMENT,null,pageNum,pageSize);
    }

}

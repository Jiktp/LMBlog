package com.yutou.controller;

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
     * 查看评论
     * @param articleId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("commentList")
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize){
        return commentService.commentList(articleId,pageNum,pageSize);
    }

    @PostMapping
    public ResponseResult addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

}

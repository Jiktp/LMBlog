package com.yutou.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yutou.contains.SystemContains;
import com.yutou.domain.ResponseResult;
import com.yutou.domain.entity.Link;
import com.yutou.domain.vo.LinkVo;
import com.yutou.mapper.LinkMapper;
import com.yutou.service.LinkService;
import com.yutou.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2025-10-27 14:47:39
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {
        //查询所有通过的友链
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemContains.LINK_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);

        //转换成vo
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links,LinkVo.class);
        //封装返回
        return ResponseResult.okResult(linkVos);
    }
}


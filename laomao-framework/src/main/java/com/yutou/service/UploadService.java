package com.yutou.service;

import com.yutou.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    ResponseResult uploadImg(MultipartFile img);
}

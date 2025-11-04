package com.yutou.service.Impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.yutou.domain.ResponseResult;
import com.yutou.enums.AppHttpCodeEnum;
import com.yutou.exception.SystemException;
import com.yutou.properties.AliOssProperties;
import com.yutou.service.UploadService;
import com.yutou.utils.PathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private AliOssProperties ossProperties;

    @Override
    public ResponseResult uploadImg(MultipartFile img) {
        //判断文件类型
        //获取原文件名
        String originalFilename = img.getOriginalFilename();
        //对文件名进行判断
        if(!originalFilename.endsWith(".png")){
            throw new SystemException(AppHttpCodeEnum.FILE_TYPE_ERROR);
        }
        //判断通过上传文件到OSS
        String filePath = PathUtils.generateFilePath(originalFilename);
        String url = uploadOss(img,filePath);
        return ResponseResult.okResult(url);
    }

    /**
     * 图片上传
     * @param imgFile
     * @param filePath
     * @return
     */
    private String uploadOss(MultipartFile imgFile, String filePath) {
        String endpoint = ossProperties.getEndpoint();
        String accessKeyId = ossProperties.getAccessKey();
        String accessKeySecret = ossProperties.getSecretKey();
        String bucketName = ossProperties.getBucketName();

        String originalFilename = imgFile.getOriginalFilename();
        String suffix = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        }

        String objectName = (filePath != null && !filePath.isEmpty() ? filePath + "/" : "images/")
                + java.util.UUID.randomUUID() + suffix;

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try (InputStream inputStream = imgFile.getInputStream()) {
            ossClient.putObject(bucketName, objectName, inputStream);
            return "https://" + bucketName + "." + endpoint + "/" + objectName;
        } catch (Exception e) {
            return null;
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}

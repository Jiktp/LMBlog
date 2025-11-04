package com.yutou;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.yutou.properties.OssProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootTest
public class OssTest {

    @Autowired
    private OssProperties ossProperties;

    @Test
    public void test() throws Exception {


        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = ossProperties.getEndpoint();
        // 从环境变量中获取访问凭证。
        String accessKeyId = ossProperties.getAccessKeyId();
        String accessKeySecret = ossProperties.getAccessKeySecret();
        // 填写Bucket名称，例如examplebucket。
        String bucketName = ossProperties.getBucketName();
        // 填写Object完整路径，例如exampledir/exampleobject.txt。
        String objectName = "images/test.jpg";
        //上传文件的地址
        String localPath = "";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // 上传本地的文件。
            InputStream inputStream = new FileInputStream(new File(localPath));
            // 使用putObject方法上传流式数据。
            ossClient.putObject(bucketName, objectName, inputStream);
            System.out.println("Stream upload succeeded: " + bucketName + "/" + objectName);
        } catch (Exception e) {
            System.out.println("Stream upload failed: " + e.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
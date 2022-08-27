package com.web.pocketmoney.service.aws;

import com.amazonaws.services.s3.AmazonS3Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class S3Delete {
    private final AmazonS3Client amazonS3Client;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public void delete(String fileKey) {
        Boolean is = amazonS3Client.doesObjectExist(bucket, fileKey);
        log.info("사진이 있나? " + is);
        if(amazonS3Client.doesObjectExist(bucket, fileKey)) {
            log.info("ㅇㅣ미지 있음 " + bucket + " " + fileKey);
            amazonS3Client.deleteObject(bucket, fileKey);
        }
    }
}

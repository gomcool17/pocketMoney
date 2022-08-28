package com.web.pocketmoney.service.aws;

import com.amazonaws.services.s3.AmazonS3Client;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.image.Image;
import com.web.pocketmoney.entity.image.ImageRepository;
import com.web.pocketmoney.entity.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class S3Delete {
    private final AmazonS3Client amazonS3Client;
    private final ImageRepository imageRepository;
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

    public void boardImageDelete(User user, Long boardId) {
        List<Image> images = imageRepository.findByBoardId(boardId);

        for(Image i : images) {
            if(amazonS3Client.doesObjectExist(bucket, i.getKey())) {
                amazonS3Client.deleteObject(bucket, i.getKey());
            }
        }
    }
}

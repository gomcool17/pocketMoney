package com.web.pocketmoney.controller.aws;

import com.web.pocketmoney.dto.aws.S3DeleteResponseDto;
import com.web.pocketmoney.service.aws.S3Delete;
import com.web.pocketmoney.service.aws.S3Uploader;
import com.web.pocketmoney.dto.aws.S3UploadResponseDto;
import com.web.pocketmoney.entity.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
@Log4j2
public class S3Controller {
    private final S3Uploader s3Uploader;
    private final S3Delete s3Delete;


    @PostMapping("/image")
    public ResponseEntity<S3UploadResponseDto> updateUserImage(@AuthenticationPrincipal User user, @RequestParam("images") MultipartFile multipartFile) throws IOException {
        log.info("s3 Contorller : " + multipartFile);
        return ResponseEntity.ok(s3Uploader.uploadFiles(multipartFile, "static"));
    }

    @DeleteMapping("/image")
    public void deleteUserImage(@RequestParam("images") String fileKey) {
        log.info("deleteUserImage : " + fileKey);
        s3Delete.delete(fileKey);
    }
}

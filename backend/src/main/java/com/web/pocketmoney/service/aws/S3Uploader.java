package com.web.pocketmoney.service.aws;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.web.pocketmoney.dto.aws.S3DeleteResponseDto;
import com.web.pocketmoney.dto.aws.S3UploadResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class S3Uploader {
    private final AmazonS3Client amazonS3Client;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public S3UploadResponseDto uploadFiles(MultipartFile multipartFile, String dirName) throws IOException {
        log.info("multipart : " + multipartFile);
        /*File uploadFile = new File(multipartFile.getOriginalFilename());
        multipartFile.transferTo(uploadFile);*/
        File uploadFile = convert(multipartFile)  // 파일 변환할 수 없으면 에러
                .orElseThrow(() -> new IllegalArgumentException("error: MultipartFile -> File convert fail"));
        log.info(uploadFile + " : " + multipartFile);
        return upload(uploadFile, dirName);
    }

    public S3UploadResponseDto upload(File uploadFile, String filePath) {
        String fileName = filePath + "/" + UUID.randomUUID() + uploadFile.getName();   // S3에 저장된 파일 이름
        log.info("fileName : " + fileName);
        String uploadImageUrl = putS3(uploadFile, fileName); // s3로 업로드
        log.info("uploadImage : " + uploadImageUrl);
        removeNewFile(uploadFile);
        return S3UploadResponseDto.builder()
                .key(fileName)
                .path(uploadImageUrl)
                .build();
    }

    // S3로 업로드
    private String putS3(File uploadFile, String fileName) {
        log.info("putS3 : ");
        log.info("uploadFile : " + uploadFile);
        log.info("fileName : " + fileName);
        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
        log.info("successPutS3");
        return amazonS3Client.getUrl(bucket, fileName).toString();
    }

    // 로컬에 저장된 이미지 지우기
    private S3DeleteResponseDto removeNewFile(File targetFile) {
        if (targetFile.delete()) {
            log.info("File delete success");
            return new S3DeleteResponseDto();
        }
        log.info("File delete fail");
        return new S3DeleteResponseDto(400);
    }

    // 로컬에 파일 업로드 하기
    private Optional<File> convert(MultipartFile file) throws IOException {
        File convertFile = new File(System.getProperty("user.dir") + "/" + file.getOriginalFilename());
        if (convertFile.createNewFile()) { // 바로 위에서 지정한 경로에 File이 생성됨 (경로가 잘못되었다면 생성 불가능)
            try (FileOutputStream fos = new FileOutputStream(convertFile)) { // FileOutputStream 데이터를 파일에 바이트 스트림으로 저장하기 위함
                fos.write(file.getBytes());
            }
            return Optional.of(convertFile);
        }
        return Optional.empty();
    }
}

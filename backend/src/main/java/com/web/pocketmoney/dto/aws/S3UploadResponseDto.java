package com.web.pocketmoney.dto.aws;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class S3UploadResponseDto {
    private String key;
    private String path;
}

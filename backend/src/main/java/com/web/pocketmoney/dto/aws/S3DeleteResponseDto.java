package com.web.pocketmoney.dto.aws;

import com.web.pocketmoney.model.CommonResult;

public class S3DeleteResponseDto extends CommonResult {
    public S3DeleteResponseDto() {

    }
    public S3DeleteResponseDto(int code) {
        super.setCode(code);
    }
}

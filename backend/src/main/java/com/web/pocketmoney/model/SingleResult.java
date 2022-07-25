package com.web.pocketmoney.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResult<T> extends CommonResult {
    private T data;
}
// CommonResult를 상속받아 API 요청 결과도 같이 출력
package com.web.pocketmoney.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageSaveDto {
    private Long roomId;
    private String writer;
    private String message;
}

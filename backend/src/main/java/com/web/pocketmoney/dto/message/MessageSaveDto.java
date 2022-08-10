package com.web.pocketmoney.dto.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageSaveDto {
    private String roomid;
    private String writer;
    private String message;
}

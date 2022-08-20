package com.web.pocketmoney.dto.chatRoom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoomRequestDto {

    private Long boardId;

    //    private Long id;
    private String name;
}

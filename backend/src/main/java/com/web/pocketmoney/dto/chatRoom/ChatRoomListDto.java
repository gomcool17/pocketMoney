package com.web.pocketmoney.dto.chatRoom;

import com.web.pocketmoney.dto.message.MessageDetailDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoomListDto {

    private Long id;
    private String name;
    private LocalDateTime regDate;
    //상대방 아이디와 닉네임
    private Long userId;
    private String nickName;




}




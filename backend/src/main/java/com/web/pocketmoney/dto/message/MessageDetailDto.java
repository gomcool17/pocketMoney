package com.web.pocketmoney.dto.message;

import com.web.pocketmoney.entity.message.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDetailDto {

    //PK 메시지아이디
    private Long messageId;
    //참조하는 채팅방의 PK
    private Long chatRoomId;

    private LocalDateTime sendDate;

    private String roomName;
    private String writer;
    private String message;

//    public static MessageDetailDto toChatMessageDetailDto(Message message){
//        MessageDetailDto messageDetailDto = new MessageDetailDto();
//
//        messageDetailDto.setChatId(message.getId());
//        messageDetailDto.setChatRoomId(message.getChatRoom().getId());
//        messageDetailDto.setRoomId(message.getChatRoom().getRoomId());
//
//        messageDetailDto.setWriter(message.getWriter());
//        messageDetailDto.setMessage(message.getMessage());
//
//        return messageDetailDto;
//
//    }


}

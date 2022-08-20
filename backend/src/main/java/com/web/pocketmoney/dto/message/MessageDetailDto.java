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

    //현재 로그인한 사용자 ID, 작성자 ID까지 WriterId

    //PK 메시지아이디
    private Long messageId;
    //참조하는 채팅방의 PK
    private Long chatRoomId;

    private LocalDateTime sendDate;

    private String roomName;
    //작성자는 닉네임으로
    private String writer;
    //작성자 아이디
    private Long writerId;
    //로그인한 사용자 아이디
    private Long myId;
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

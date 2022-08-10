package com.web.pocketmoney.dto.chatRoom;

import com.web.pocketmoney.entity.room.ChatRoom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomDetailDto {

    private Long chatRoomId;
    private String chatMentor;
    private String roomId;
    private String name;

    public static ChatRoomDetailDto toChatRoomDetailDto(ChatRoom chatRoom){
        ChatRoomDetailDto chatRoomDetailDto = new ChatRoomDetailDto();

        chatRoomDetailDto.setChatRoomId(chatRoom.getId());
        chatRoomDetailDto.setChatMentor(chatRoom.getChatMentor());
        chatRoomDetailDto.setRoomId(chatRoom.getRoomId());
        chatRoomDetailDto.setName(chatRoom.getRoomName());

        return chatRoomDetailDto;
    }
}

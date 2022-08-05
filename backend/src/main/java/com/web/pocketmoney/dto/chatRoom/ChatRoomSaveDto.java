package com.web.pocketmoney.dto.chatRoom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomSaveDto {

    private String chatMentor;
    private String roomId;
    private String name;

    private Set<WebSocketSession> sessions = new HashSet<>();

    public static ChatRoomSaveDto create(String name){
        ChatRoomSaveDto room = new ChatRoomSaveDto();

        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}

package com.web.pocketmoney.dto.chatRoom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoomSaveDto {

    private Long employerId;

    private Long employeeId;

//    private Long id;
    private String name;

    private Set<WebSocketSession> sessions = new HashSet<>();

    public static ChatRoomSaveDto create(String name){
        ChatRoomSaveDto room = new ChatRoomSaveDto();

//        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}

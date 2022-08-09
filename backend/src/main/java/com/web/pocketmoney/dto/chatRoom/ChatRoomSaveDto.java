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


}

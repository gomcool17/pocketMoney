package com.web.pocketmoney.entity.room;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom,Long> {

    //방 주소를 통해 ChatRoomEntity 가져오기
    ChatRoom findByRoomId(String roomId);

}
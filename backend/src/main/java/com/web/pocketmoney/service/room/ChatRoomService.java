package com.web.pocketmoney.service.room;


import com.web.pocketmoney.dto.chatRoom.ChatRoomDetailDto;
import com.web.pocketmoney.dto.message.MessageDetailDto;

import java.util.List;

public interface ChatRoomService {

   List<ChatRoomDetailDto> findAllRooms();

   ChatRoomDetailDto findRoomById(String roomId);

   //채팅방 생성
   void createChatRoomDto(String name, int password, String chatMentor);

   void deleteById(Long chatRoomId);

   List<MessageDetailDto> findAllChatByRoomId(String roomId);



}

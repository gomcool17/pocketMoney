package com.web.pocketmoney.service.room;


import com.web.pocketmoney.dto.chatRoom.ChatRoomDetailDto;
import com.web.pocketmoney.dto.chatRoom.ChatRoomListDto;
import com.web.pocketmoney.dto.chatRoom.ChatRoomRequestDto;
import com.web.pocketmoney.dto.chatRoom.ChatRoomSaveDto;
import com.web.pocketmoney.dto.message.MessageDetailDto;
import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.entity.user.User;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public interface ChatRoomService {

   List<ChatRoomListDto> findAllRooms(Long userId);

   ChatRoomDetailDto findRoomById(Long id, Long userId);

   //채팅방 생성
   void createRoom(ChatRoomRequestDto chatRoomRequestDto, Long userId);

   void deleteById(Long chatRoomId);

//   List<MessageDetailDto> findAllChatByRoomId(Long id);

   // 채팅방 만들 때
   default ChatRoom chatRoomSaveDtoToEntity(ChatRoomSaveDto chatRoomSaveDto){

      User employer = User.builder()
              .id(chatRoomSaveDto.getEmployerId())
              .build();

      User employee = User.builder()
              .id(chatRoomSaveDto.getEmployeeId())
              .build();

      ChatRoom chatRoom = ChatRoom.builder()
              .roomName(chatRoomSaveDto.getName())
              .employerId(employer)
              .employeeId(employee)
              .build();
      return chatRoom;
   }





}

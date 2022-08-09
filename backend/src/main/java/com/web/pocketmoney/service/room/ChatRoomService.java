package com.web.pocketmoney.service.room;


import com.web.pocketmoney.dto.chatRoom.ChatRoomDetailDto;
import com.web.pocketmoney.dto.chatRoom.ChatRoomSaveDto;
import com.web.pocketmoney.dto.message.MessageDetailDto;
import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.entity.user.User;

import java.util.List;
import java.util.stream.Collectors;

public interface ChatRoomService {

   List<ChatRoomDetailDto> findAllRooms(Long userId);

   ChatRoomDetailDto findRoomById(Long id);

   //채팅방 생성
   void createRoom(ChatRoomSaveDto chatRoomSaveDto);

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

   // 채팅방 하나 불러올 때, 메시지까지
   default ChatRoomDetailDto entitiesToDetailDto(ChatRoom chatRoom, List<Message> messages){

      User employee = User.builder()
              .id(chatRoom.getEmployeeId().getId())
              .build();

      User employer = User.builder()
              .id(chatRoom.getEmployerId().getId())
              .build();

      ChatRoomDetailDto chatRoomDetailDto = ChatRoomDetailDto.builder()
              .id(chatRoom.getId())
              .name(chatRoom.getRoomName())
              .employeeId(employee.getId())
              .employerId(employer.getId())
              .build();

      List<MessageDetailDto> messageDetailDtoList = messages.stream().map(message -> {
         return MessageDetailDto.builder()
                 .messageId(message.getId())
                 .chatRoomId(message.getChatRoom().getId())
                 .roomName(message.getChatRoom().getRoomName())
                 .writer(message.getWriterNickName())
                 .message(message.getMessage())
                 .build();
      }).collect(Collectors.toList());

      chatRoomDetailDto.setMessageDetailDtoList(messageDetailDtoList);
      return chatRoomDetailDto;
   }

   //채팅방 여러개 불러올 때
   default ChatRoomDetailDto entityToDto(ChatRoom chatRoom){
      ChatRoomDetailDto chatRoomDetailDto = ChatRoomDetailDto.builder()
              .id(chatRoom.getId())
              .name(chatRoom.getRoomName())
              .employeeId(chatRoom.getEmployeeId().getId())
              .employerId(chatRoom.getEmployerId().getId())
              .build();

      return chatRoomDetailDto;
   }

}

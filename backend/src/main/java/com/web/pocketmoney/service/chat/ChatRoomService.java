//package com.web.pocketmoney.service.chat;
//
//import com.web.pocketmoney.dto.chatRoom.ChatRoomDto;
//import com.web.pocketmoney.entity.room.ChatRoom;
//import com.web.pocketmoney.entity.user.User;
//
//public interface ChatRoomService {
//
//    void create(ChatRoomDto chatRoomDto);
//
//    void delete(Long chatRoomId);
//
//    default ChatRoom dtoToEntity(ChatRoomDto chatRoomDto){
//
//        User sendUser = User.builder()
//                .id(chatRoomDto.getSenderId())
//                .build();
//
//        User recipientUser = User.builder()
//                .id(chatRoomDto.getRecipientId())
//                .build();
//
//        ChatRoom chatRoom = ChatRoom.builder()
//                .id(chatRoomDto.getId())
//                .chatId(chatRoomDto.getChatId())
//                .senderId(sendUser)
//                .recipientId(recipientUser)
//                .build();
//        return chatRoom;
//    }
//
//    default ChatRoomDto entityToDto(ChatRoom chatRoom){
//
//        User sendUser = User.builder()
//                .id(chatRoom.getId())
//                .build();
//
//        User recipientUser = User.builder()
//                .id(chatRoom.getId())
//                .build();
//
//        ChatRoomDto chatRoomDto = ChatRoomDto.builder()
//                .id(chatRoom.getId())
//                .chatId(chatRoom.getChatId())
//                .senderId(sendUser.getId())
//                .recipientId(recipientUser.getId())
//                .build();
//
//        return chatRoomDto;
//
//    }
//
//
//
//}

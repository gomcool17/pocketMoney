//package com.web.pocketmoney.service.chat;
//
//import com.web.pocketmoney.dto.chatRoom.ChatRoomDto;
//import com.web.pocketmoney.entity.room.ChatRoom;
//import com.web.pocketmoney.entity.room.ChatRoomRepository;
//import com.web.pocketmoney.exception.ChatRoomNotFoundException;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Service;
//
//@Service
//@Log4j2
//@RequiredArgsConstructor
//public class ChatRoomServiceImpl implements ChatRoomService {
//
////    private Map<String, ChatRoom> chatRooms;
////
////    @PostConstruct
////    //의존관계가 주입되면 실행되는 코드
////    private void init(){
////        chatRooms = new LinkedHashMap<>();
////    }
////
////    //채팅방 불러오기
////    public List<ChatRoom> findAllRoom(){
////        //채팅방 최근 생성 순으로 반환
////        List<ChatRoom> result = new ArrayList<>(chatRooms.values());
////        Collections.reverse(result);
////
////        return result;
////    }
////
////    //채팅방 하나 불러오기
////    public ChatRoom findById(String roomId){
////        return chatRooms.get(roomId);
////    }
////
////    //채팅방 생성
////    public ChatRoom createRoom(String name){
////        ChatRoom chatRoom = ChatRoom.create(name);
////        chatRooms.put(chatRoom.getRoomId(), chatRoom);
////        return chatRoom;
////    }
//
//    private final ChatRoomRepository chatRoomRepository;
//
//
//    @Override
//    public void create(ChatRoomDto chatRoomDto) {
//        ChatRoom chatRoom = dtoToEntity(chatRoomDto);
//        chatRoomRepository.save(chatRoom);
//    }
//
//    @Override
//    public void delete(Long chatRoomId) {
//        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId)
//                .orElseThrow(()-> new ChatRoomNotFoundException(
//                        "해당 채팅방이 없습니다."
//                ));
//
//        chatRoomRepository.deleteById(chatRoomId);
//    }
//}

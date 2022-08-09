package com.web.pocketmoney.controller.chatroom;

//import com.web.pocketmoney.dto.chatRoom.ChatRoomDto;
//import com.web.pocketmoney.service.chat.ChatRoomService;
import com.web.pocketmoney.dto.chatRoom.ChatRoomDetailDto;
import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.service.UserService;
import com.web.pocketmoney.service.room.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.web.pocketmoney.model.SessionConst.LOGIN_ID;
import static com.web.pocketmoney.model.SessionConst.LOGIN_NICKNAME;
import static org.springframework.messaging.simp.stomp.StompHeaders.LOGIN;

@RestController
@RequestMapping("/room")
@Log4j2
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;
    private final UserService userService;

    //모든 채팅방 불러오기
    @GetMapping("/list/{userId}")
    public ResponseEntity<List<ChatRoomDetailDto>> myChatRoom(@PathVariable Long id){
        List<ChatRoomDetailDto> roomDetailDtoList = chatRoomService.findAllRooms(); //아이디가 없어도 SUBSCRIBE한 것만 불러오는지 확인
        return ResponseEntity.ok(roomDetailDtoList);
    }

    //채팅방 삭제
    @DeleteMapping("/{chatRoomId}")
    public ResponseEntity delete(@PathVariable("chatRoomId") Long id){
        log.info("ChatRoom : "+ id);
        chatRoomService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //채팅방 개설
    @PostMapping("")
    public ResponseEntity create(@RequestParam String name, @RequestParam int password, HttpSession session){
        Long userId = (Long) session.getAttribute(LOGIN_ID);
        String userNickName = (String) session.getAttribute(LOGIN_NICKNAME);

        log.info("# Create Chat Room, name : "+ name);
        chatRoomService.createChatRoomDto(name, password, userNickName);

        return ResponseEntity.noContent().build();
    }

    //채팅방 조회
    @GetMapping("{roomId}")
    public ResponseEntity<ChatRoomDetailDto> getRoom(@PathVariable String roomId, HttpSession session){
        Long userId = (Long) session.getAttribute(LOGIN_ID);
//        String userNickName = userService.getUser(userId).getNickName();

        log.info("get Chat Room, roomID : " + roomId);
        ChatRoomDetailDto chatRoomDto = chatRoomService.findRoomById(roomId);
        return ResponseEntity.ok(chatRoomDto);
    }










}

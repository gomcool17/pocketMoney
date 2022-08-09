package com.web.pocketmoney.controller.chatroom;

//import com.web.pocketmoney.dto.chatRoom.ChatRoomDto;
//import com.web.pocketmoney.service.chat.ChatRoomService;
import com.web.pocketmoney.dto.chatRoom.ChatRoomDetailDto;
import com.web.pocketmoney.dto.chatRoom.ChatRoomSaveDto;
import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.service.UserService;
import com.web.pocketmoney.service.room.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @GetMapping("/list")
    public ResponseEntity<List<ChatRoomDetailDto>> myChatRoom(@AuthenticationPrincipal User user){
        List<ChatRoomDetailDto> roomDetailDtoList = chatRoomService.findAllRooms(user.getId()); //아이디가 없어도 SUBSCRIBE한 것만 불러오는지 확인
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
    @PostMapping("") //RequestMapping("room")
    public ResponseEntity create(@RequestBody ChatRoomSaveDto chatRoomSaveDto, HttpSession session, @AuthenticationPrincipal User user){
//        Long userId = (Long) session.getAttribute(LOGIN_ID);
        //채팅을 거는 것은 구직자이므로 현재 로그인한 유저
        chatRoomSaveDto.setEmployeeId(user.getId());
        log.info(chatRoomSaveDto);
//        String userNickName = (String) session.getAttribute(LOGIN_NICKNAME);
        String userNickName = user.getNickName();

        log.info("# Create Chat Room, name : "+ chatRoomSaveDto.getName());
        chatRoomService.createRoom(chatRoomSaveDto);

        return ResponseEntity.noContent().build();
    }

    //채팅방 조회
    @GetMapping("{roomId}")
    public ResponseEntity<ChatRoomDetailDto> getRoom(@PathVariable Long roomId, HttpSession session){
        Long userId = (Long) session.getAttribute(LOGIN_ID);
//        String userNickName = userService.getUser(userId).getNickName();

        log.info("get Chat Room, roomID : " + roomId);
        ChatRoomDetailDto chatRoomDto = chatRoomService.findRoomById(roomId);
        return ResponseEntity.ok(chatRoomDto);
    }










}

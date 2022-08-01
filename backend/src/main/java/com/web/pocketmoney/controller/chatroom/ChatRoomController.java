package com.web.pocketmoney.controller.chatroom;

import com.web.pocketmoney.dto.chat.ChatRoomDto;
import com.web.pocketmoney.service.chat.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
@Log4j2
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @PostMapping("") //RequestMapping("/room")
    public ResponseEntity<Void> createRoom(@RequestBody ChatRoomDto chatRoomDto){
        chatRoomService.create(chatRoomDto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}") //RequestMapping("/room")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        chatRoomService.delete(id);

        return ResponseEntity.noContent().build();
    }





}

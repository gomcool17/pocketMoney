package com.web.pocketmoney.entity.room;

import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.entity.user.User;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Entity
public class ChatRoom {

    //채팅방 id == 추후 MatchId + 진영 코드 + 소환사 명
//    private String roomId;
    //set은 중복없는 리스트, 입장시에는 채팅방의 session 정보 리스트에 클라이언트의 session을 추가
    //채팅방에 메시지가 도착할 경우 채팅방의 모든 session에 메시지 발송
    
    //pub/sub 방식을 이용하면 구독자 관리가 알아서 되므로 Set<>으로 관리했던 웹소켓 세션 관리가 필요없다.
    //또한 발송의 구현도 알아서 해결이 되므로 일일이 클라이언트에게 메시지를 발송하는 구현이 사라진다.
    //그래서 session.parallemStream().forEach()를 뺌
//    @Builder.Default
//    private Set<WebSocketSession> sessions = new HashSet<>();

//    public ChatRoom(String roomId){
//        this.roomId = roomId;
//    }

//    public void handleActions(WebSocketSession session, MessageDto message, MessageService msgService){
//        log.info("session:::", session, message);
//        if(message.getMessageType().equals(MessageDto.MessageType.ENTER)){
//            sessions.add(session);
//            message.setMessage(message.getSender()+"님이 입장했습니다.");
//        }
//        log.info("sessions::", message);
//        sendMessage(message, msgService);
//    }

//    public <T> void sendMessage(T message, MessageService messageService){
//        log.info("sessions: {}",message, sessions);
//        sessions.parallelStream().forEach(session -> messageService.sendMessage(session, message));
//    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatRoom_id")
    private Long id;

    @Column(nullable = false)
    private String roomName;

    @ManyToOne(fetch = FetchType.LAZY)
    private User employerId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User employeeId;

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    //객체의 두 관계중 하나를 연관관계의 주인으로 지정한다.
    //연관관계의 주인만이 외래 키를 관리(등록, 수정)한다. DB에 접근한다.
    //주인이 아닌 쪽은 읽기만 가능하다.
    //mappedBy = 연관관계의 주인이 아니라는 뜻, 컬럼을 만들지 않음
    //일반적으로 외래키는 ManyToOne이 가지고 있으므로 연관관계의 주인은 ManyToOne으로 생각하면 됨
    @OneToMany(mappedBy = "chatRoom", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> chatMessageList = new ArrayList<>();

//    public static ChatRoom toChatRoomEntity(String roomName, String employer, String employee){
//        ChatRoom chatRoom = new ChatRoom();
//        chatRoom.setRoomName(roomName);
//        chatRoom.setEmployee(employee);
//        chatRoom.setEmployer(employer);
//        return chatRoom;
//    }
    
}

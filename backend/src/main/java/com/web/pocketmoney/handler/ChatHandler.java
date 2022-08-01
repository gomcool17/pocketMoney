package com.web.pocketmoney.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

// 소켓통신은 서버와 클라이언트가 1:N 관계를 맺는다. 즉 하나의 서버에 다수의 클라이언트가 접속한다.
// 따라서 서버는 다수의 클라이언트가 보낸 메세지를 처리할 핸들러가 필요하다. 텍스트 기반의 채팅을 구현하므로
// 'TextWebSocketHandler'를 상속받아서 작성한다. Client로부터 받은 메시지를 Log출력하고 클라이언트에게 환영하는 메세지를 보내는 역할을 한다.
@Component
@Log4j2
public class ChatHandler extends TextWebSocketHandler {

    //접속해있는 클라이언트들의 리스트
    private static List<WebSocketSession> list = new ArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        // payload란 전송되는 데이터, 보내고자 하는 데이터 자체를 의미함
        String payload = message.getPayload();
        log.info("payload : " + payload);

        for(WebSocketSession sess: list){
            sess.sendMessage(message);
        }
    }

    // Client가 접속 시 호출되는 메서드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        list.add(session);
        log.info(session+ "클라이언트 접속");
    }

    //Client가 접속 해제시 호출되는 메서드
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        log.info(session + "클라이언트 접속 해제");
        list.remove(session);
    }

}
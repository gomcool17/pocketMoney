package com.web.pocketmoney.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 소켓통신은 서버와 클라이언트가 1:N 관계를 맺는다. 즉 하나의 서버에 다수의 클라이언트가 접속한다.
// 따라서 서버는 다수의 클라이언트가 보낸 메세지를 처리할 핸들러가 필요하다. 텍스트 기반의 채팅을 구현하므로
// 'TextWebSocketHandler'를 상속받아서 작성한다. Client로부터 받은 메시지를 Log출력하고 클라이언트에게 환영하는 메세지를 보내는 역할을 한다.
@Component
@Log4j2
public class ChatHandler extends TextWebSocketHandler {

    //session은 사용자가 웹 서버에 접속한 시점으로부터 웹 브라우저를 종료하여 연결을 끝내는 시점까지
    //같은 사용자로부터 오는 일련의 요청을 하나의 상태로 보고, 일정하게 상태를 유지해준다.
    //각 클라이언트의 고유세션 ID를 부여하고, 브라우저를 닫거나, 서버에서 세션을 삭제했을 때 삭제된다.
    //클라이언트 요청(사용자 웹 접근, http요청) > 서버는 접근클라이언트의 Request-Header필드인 cookie확인, 클라이언트가 세션ID를 보냈는지 확인
    //세션ID가 존재하지 않으면, 서버는 세션ID를 생성 후 클라이언트에게 전송 > 서버에서 클라이언트로 준 세션ID를 쿠키를 사용해 서버에 저장
    //클라이언트는 재접속시, 이 쿠키를 사용하여 세션ID값을 서버에 전달.
    //ex) 화면이동해도 로그인이 풀리지 않고 로그아웃전까지 유지
    //클라이언트의 요청에 따른 정보를 방문자 메모리가 아닌 웹 서버가 세션 아이디 파일을 만들어 서비스가 돌아가고 있는 서버에 저장한다.

    //접속해있는 클라이언트들의 리스트
    private static List<WebSocketSession> list = new ArrayList<>();
    private static List<String> onlineList = new ArrayList<>();
    Map<String, WebSocketSession> userSession = new HashMap<>();

    //ObjectMapper : JSON 컨텐츠를 java객체로 역직렬화 또는 java객체를 JSON으로 직렬화할 때 사용하는 Jackson 라이브러리 클래스
    ObjectMapper json = new ObjectMapper();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        // websocket을 통해서 받은 메세지를 처리하는 메소드

        for(WebSocketSession sess: list){
            sess.sendMessage(message);
        }

        // json test
        Map<String, Object> dataMap = new HashMap<>();

        // master status
        String masterStatus = null;
        if(userSession.containsKey("master")){
            masterStatus = "online";
        } else {
            masterStatus = "offline";
        }

        // sending time
        LocalDateTime currentTime = LocalDateTime.now();
        String time = currentTime.format(DateTimeFormatter.ofPattern("hh:mm a, E"));

        // message data
        // httpSession에서 설정한 attribute를 가져온다.
        String senderId = (String) session.getAttributes().get("sessionId");
        // payload란 전송되는 데이터, 보내고자 하는 데이터 자체를 의미함, 메세지에 담긴 텍스트값
        String payload = message.getPayload();
        log.info("payload : " + payload);

        dataMap = jsonToMap(payload);
        dataMap.put("senderId", senderId);
        dataMap.put("time", time);
        dataMap.put("masterStatus", masterStatus);
        dataMap.put("onlineList", onlineList);

        String receiverId = (String) dataMap.get("receiverId");

        log.info("final dataMap >>> " + dataMap);

        // send a message
        log.info("receiver session >>> " + userSession.get(receiverId));
        // json은 ObjectMapper, write는 java --> json으로 변경
        String msg = json.writeValueAsString(dataMap);

        if (userSession.get(receiverId) != null){
            userSession.get(receiverId).sendMessage(new TextMessage(msg)); // send to receiver
        }

        // send a message myself
        if(senderId.equals(receiverId)){
            dataMap.put("receiverId", senderId);
            msg = json.writeValueAsString(dataMap);
            session.sendMessage(new TextMessage(msg)); // send to myself
        }

    }

    // json string parsing to map
    public Map<String, Object> jsonToMap(String jsonString) throws JsonMappingException, JsonProcessingException{
        Map<String, Object> map = new HashMap<>();
        ObjectMapper jmapper = new ObjectMapper();
        // readValue는 json을 java객체로 변환해줌
        map = jmapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {
        });
        return map;
    }

    // Client가 접속 시 호출되는 메서드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        // websocket에 session이 접속했을 때, 처리하는 메소드
        list.add(session);
        log.info(session+ "클라이언트 접속");
    }

    //Client가 접속 해제시 호출되는 메서드
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        // websocket에 session이 접속을 해제했을 때, 처리하는 메소드
        log.info(session + "클라이언트 접속 해제");
        list.remove(session);
    }

}
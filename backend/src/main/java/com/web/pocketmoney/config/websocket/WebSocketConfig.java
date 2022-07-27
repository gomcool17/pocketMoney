//package com.web.pocketmoney.config.websocket;
//
//import com.web.pocketmoney.handler.ChatHandler;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//// 핸들러를 이용해 WebSocket을 활성화하기 위한 Config 작성
//// @EnableWebSocket 어노테이션 사용하여 WebSocket을 활성화한다.
//// WebScoket에 접속하기 위한 Endpoint는 /chat으로 설정
//// 도메인이 다른 서버에서도 접속 가능하도록 CORS:setAllowedOrigins("*"); 를 추가
//// ws://localhost:8080/chat으로 커넥션을 연결하고 메시지 통신 가능
//@Configuration
//@RequiredArgsConstructor
//@EnableWebSocket // WebSocket을 활성화
//public class WebSocketConfig implements WebSocketConfigurer {
//
//    //CORS
//    //교차 출처 리소스 공유(Cross-Origin Resource Sharing, CORS)는 추가 HTTP헤더를 사용해
//    //한 출처에서 실행 중인 웹 어플리케이션이 다른 출처의 선택한 자원에 접근할 수 있도록
//    private final ChatHandler chatHandler;
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//
//        registry.addHandler(chatHandler, "ws/chat").setAllowedOrigins("*");
//    }
//}
package com.web.pocketmoney.config.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//메시지 브로커에 대한 설정을 해주는 Config
@Configuration
@EnableWebSocketMessageBroker
public class ChatConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    // Client에서 WebSocket을 연결할 때 사용할 API 경로를 결정해주는 메서드.
    // 새로운 핸드쉐이크 커넥션을 생성할 때 사용됨.
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ws/chat").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    // 메시지 받을 때 관련 경로 설정
    // "/queue", "/topic" 이 두 경로가 prefix에 붙은 경우, messageBroker가 잡아서
    // 해당 채팅방을 구독하고 있는 클라이언트에게 메시지를 전달해준다.
    // 주로 "/queue"는 1대1 메시징, "/topic"은 1대다 메시징일때 주로 사용한다.
    public void configureMessageBroker(MessageBrokerRegistry registry){

        registry.enableSimpleBroker("/queue", "/topic");

        // 클라이언트가 메시지를 보낼 때 경로 맨 앞에 "/app"이 붙어있으면 Broker로 보내짐.
        registry.setApplicationDestinationPrefixes("/app");
    }

}

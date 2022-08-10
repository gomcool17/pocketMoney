package com.web.pocketmoney.config.websocket;

//import com.web.pocketmoney.handler.ChatHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

// 핸들러를 이용해 WebSocket을 활성화하기 위한 Config 작성
// @EnableWebSocket 어노테이션 사용하여 WebSocket을 활성화한다.
// WebScoket에 접속하기 위한 Endpoint는 /chat으로 설정
// 도메인이 다른 서버에서도 접속 가능하도록 CORS:setAllowedOrigins("*"); 를 추가
// ws://localhost:8080/ws/chat으로 커넥션을 연결하고 메시지 통신 가능
@Slf4j
@Configuration
@RequiredArgsConstructor
//@EnableWebSocket // WebSocket을 활성화
//STOMP는 메시지 전송을 효율적으로 하기 위한 프로토콜로, PUB/SUB구조로 되어 있음
//메시지를 전송/받아서 처리하는 부분이 확실하게 구조로 정해져 명확하게 인지하고 개발 가능
//클라이언트/서버간 전송시 메시지의 유형, 형식과 내용을 정의한다. 헤더에 값을 세팅할 수 있어서 헤더 값을 기반으로 통신 시 인증처리 구현 가능
//채팅방 생성: 우체통(Topic)을 만듬
//채팅방에 입장: 구독자로서 SUBscriber가 됨
//채팅에 글 쓰기: 구독자 우체통에 신문을 넣는PUBlisher
//Message Brocker는 Publisher로부터 전달받은 메시지를 Subscriber에게 주고 받게 해주는 중간 역할, 집배원 느낌
//클라이언트는 SEND, SUBSCRIBE 명령어를 통해 메시지의 내용과 수신 대상을 설명하는 "destination"헤더와 함께 메시지에 대한 전송이나 구독 가능
@EnableWebSocketMessageBroker //STOMP를 사용하기 위해 선언
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //CORS : 도메인이 다른 서버에서도 접속 가능하도록
    //교차 출처 리소스 공유(Cross-Origin Resource Sharing, CORS)는 추가 HTTP헤더를 사용해
    //한 출처에서 실행 중인 웹 어플리케이션이 다른 출처의 선택한 자원에 접근할 수 있도록
//    private final ChatHandler chatHandler;

    //pub/sub 메시징을 구현하기 위해
    //메시지를 발행하는 요청의 prefix는 [/pub]으로 시작
    //메시지를 구독하는 요청의 prefix는 [/sub]으로 시작하도록 설정


    //stomp의 websocket의 연결 endpoint는 /ws-swoomi로 설정한다. 즉 개발서버의 접속 주소는
    //[ws://localhost:8080/stomp/chat]가 된다. WebSocket또는 SockJs는 /stomp/chat와 핸드쉐이크 과정을 통해 커넥션이 연결된다.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp/chat")
//                .setAllowedOriginPatterns("*")
                .setAllowedOrigins("http://localhost:8080")
                .withSockJS(); //클라이언트와의 연결은 SockJs()로 하기 때문에 달아줌
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        //Client에서 Send요청을 처리
        //Spring docs에서는 /topic, /queue로 나오나 편의상 /pub, /sub로 변경
        //해당 경로로 SimpleBroker를 등록.
        //SimpleBroker는 해당하는 경로를 SUBSCRIBE하는 Client에게 메시지를 전달하는 간단한 작업을 수행
        registry.enableSimpleBroker("/sub");
        registry.setApplicationDestinationPrefixes("/pub");

    }
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        // ws프로토콜 /ws/chat하위의 모든 uri에서 chatHandler를 사용한다는 의미
//        registry.addHandler(chatHandler, "/ws").setAllowedOrigins("*")
//                .addInterceptors(new HttpSessionHandshakeInterceptor());
        // interceptor for adding httpsession into websocket session
        // addInterceptors는 핸드쉐이크를 할 때, http의 session을 가져오기 위한 인터셉터를 추가, 없어도 됨 하지만
        // 클라이언트가 브라우저를 통해 웹 사이트에 접속하면 서버는 클라이언트를 구분할 수 있게 각자 고유의 값이 담긴 session을 생성해서 유저에게 전송한다.
        // 이 session은 HTTP상의 session이고, 이 속에 들어있는 session id를 가공해서 사용할 필요가 있다.
        // websocket과 http는 서로 다른 session을 생성하기 때문에 웹 페이지의 홈 session id를 가공해 attribute에 저장해놓은 것을 ws에선 가져올 수 없다.
        // 그래서 registry에 addInterceptors를 추가해 HTTP를 WS으로 변경할 때 interceptor가 작용해 HTTP session의 attributes를 가져오도록 한다.


//    }
    // 참고 : https://reinvestment.tistory.com/57
    // 참고 소스코드 : https://github.com/wjgin/Spring-boot-drill/tree/master/itsme

    //참고 : https://ws-pace.tistory.com/105?category=968973
    //참고 : https://github.com/HelloCdpa/cocolo220129/tree/master/src/main/java/com/phl/cocolo/repository
}
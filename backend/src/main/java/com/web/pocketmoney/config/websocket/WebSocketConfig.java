package com.web.pocketmoney.config.websocket;

import com.web.pocketmoney.handler.ChatHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

// 핸들러를 이용해 WebSocket을 활성화하기 위한 Config 작성
// @EnableWebSocket 어노테이션 사용하여 WebSocket을 활성화한다.
// WebScoket에 접속하기 위한 Endpoint는 /chat으로 설정
// 도메인이 다른 서버에서도 접속 가능하도록 CORS:setAllowedOrigins("*"); 를 추가
// ws://localhost:8080/ws/chat으로 커넥션을 연결하고 메시지 통신 가능
@Configuration
@RequiredArgsConstructor
@EnableWebSocket // WebSocket을 활성화
public class WebSocketConfig implements WebSocketConfigurer {

    //CORS
    //교차 출처 리소스 공유(Cross-Origin Resource Sharing, CORS)는 추가 HTTP헤더를 사용해
    //한 출처에서 실행 중인 웹 어플리케이션이 다른 출처의 선택한 자원에 접근할 수 있도록
    private final ChatHandler chatHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // ws프로토콜 /ws/chat하위의 모든 uri에서 chatHandler를 사용한다는 의미
        registry.addHandler(chatHandler, "/ws/chat").setAllowedOrigins("*")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
        // interceptor for adding httpsession into websocket session
        // addInterceptors는 핸드쉐이크를 할 때, http의 session을 가져오기 위한 인터셉터를 추가, 없어도 됨 하지만
        // 클라이언트가 브라우저를 통해 웹 사이트에 접속하면 서버는 클라이언트를 구분할 수 있게 각자 고유의 값이 담긴 session을 생성해서 유저에게 전송한다.
        // 이 session은 HTTP상의 session이고, 이 속에 들어있는 session id를 가공해서 사용할 필요가 있다.
        // websocket과 http는 서로 다른 session을 생성하기 때문에 웹 페이지의 홈 session id를 가공해 attribute에 저장해놓은 것을 ws에선 가져올 수 없다.
        // 그래서 registry에 addInterceptors를 추가해 HTTP를 WS으로 변경할 때 interceptor가 작용해 HTTP session의 attributes를 가져오도록 한다.


    }
    // 참고 : https://reinvestment.tistory.com/57
    // 참고 소스코드 : https://github.com/wjgin/Spring-boot-drill/tree/master/itsme

}
package com.study.chatting.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

@Configuration
@RequiredArgsConstructor
public class StompHandler implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        String sessionId = accessor.getSessionId();

        switch(accessor.getCommand()) {
            case CONNECT:
                System.out.println("세션 들어옴 -> " + sessionId);
                break;
            case DISCONNECT:
                System.out.println("세션 끊음 ->" + sessionId);
                break;
            case SUBSCRIBE:
                System.out.println("구독 (" + accessor.getDestination() + ") -> " + sessionId);
                break;
            default:
                System.out.println("다른 상태 -> " + accessor.getCommand());
                break;
        }
        return message;
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);

        return message;
    }
}

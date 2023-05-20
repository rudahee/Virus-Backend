package com.virus.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class SocketConfig implements WebSocketMessageBrokerConfigurer {

	  @Override
	  public void configureMessageBroker(MessageBrokerRegistry config) {
	    config.enableSimpleBroker("/queue");
	    config.setApplicationDestinationPrefixes("/app");
	  }
	  
	  @Override
	  public void registerStompEndpoints(StompEndpointRegistry registry) {
	    registry.addEndpoint("/game-ws").setAllowedOrigins("*").withSockJS();
	  }
}

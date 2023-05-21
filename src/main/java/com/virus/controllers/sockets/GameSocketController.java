package com.virus.controllers.sockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class GameSocketController {
	
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@CrossOrigin(origins = "*")
	@MessageMapping("/{room}")
	public void joinPartida(@DestinationVariable String room, Object json) throws Exception {
		  messagingTemplate.convertAndSend("/queue/game/" + room, json);

	}
}

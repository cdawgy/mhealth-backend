package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.websocket.GameState;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class WebsocketController {
    private SimpMessagingTemplate template;

    public WebsocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/state/{room}")
    public void updateState(@DestinationVariable String room, GameState gameState) throws Exception {
        this.template.convertAndSend("/topic/room/" + room, gameState);
    }
}

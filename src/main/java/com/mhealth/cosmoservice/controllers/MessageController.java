package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.Message;
import main.java.com.mhealth.cosmoservice.models.payloads.MessagePayload;
import main.java.com.mhealth.cosmoservice.services.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/message")
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/new")
    void createNewMessage(@RequestBody MessagePayload messagePayload) {
        messageService.saveMessageToDb(messagePayload);
    }

    @GetMapping("/user/{accountId}")
    List<Message> getAllMessages(@PathVariable int accountId) {
        return messageService.getListOfMessagesForId(accountId);
    }

    @GetMapping("/all")
    List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{messageId}")
    Message getMessage(@PathVariable int messageId) {
        return messageService.getMessageOfId(messageId);
    }

    @GetMapping("/read/{messageId}")
    void readMessage(@PathVariable int messageId) {
        messageService.readMessage(messageId);
    }
}

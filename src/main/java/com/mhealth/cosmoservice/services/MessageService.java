package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.models.Message;
import main.java.com.mhealth.cosmoservice.models.payloads.MessagePayload;
import main.java.com.mhealth.cosmoservice.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    private String READ_STATE = "read";
    private String NOT_READ_STATE = "notRead";

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void saveMessageToDb(MessagePayload messagePayload) {
        var message = new Message();
        message.setParentId(messagePayload.getSelectedParent());
        message.setResourceId(messagePayload.getSelectedResource());
        message.setMessageBody(messagePayload.getMessageBody());
        message.setReadState(NOT_READ_STATE);

        messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public List<Message> getListOfMessagesForId(int accountId) {
        return messageRepository.findByParentIdIs(accountId);
    }

    public Message getMessageOfId(int messageId) {
        return messageRepository.findById((long) messageId).orElse(null);
    }

    public void readMessage(int messageId) {
        var message = getMessageOfId(messageId);
        message.setReadState(READ_STATE);
        messageRepository.save(message);
    }
}

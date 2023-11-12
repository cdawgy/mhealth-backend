package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.InMemoryDatabase;
import main.java.com.mhealth.cosmoservice.models.Message;
import main.java.com.mhealth.cosmoservice.models.payloads.MessagePayload;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
//    private MessageRepository messageRepository;
    private String READ_STATE = "read";
    private String NOT_READ_STATE = "notRead";

    public MessageService() {
//        this.messageRepository = messageRepository;
    }

    public void saveMessageToDb(MessagePayload messagePayload) {
//        var message = new Message();
//        message.setParentId(messagePayload.getSelectedParent());
//        message.setResourceId(messagePayload.getSelectedResource());
//        message.setMessageBody(messagePayload.getMessageBody());
//        message.setReadState(NOT_READ_STATE);

    }

    public List<Message> getAllMessages() {
        return InMemoryDatabase.MessageTable;
    }

    public List<Message> getListOfMessagesForId(int accountId) {
        return InMemoryDatabase.MessageTable.stream().filter(message -> message.getParentId() == accountId).collect(Collectors.toList());
    }

    public Message getMessageOfId(int messageId) {
        return InMemoryDatabase.MessageTable.stream().filter(message -> message.getId() == messageId).findFirst().orElse(null);
    }

    public void readMessage(int messageId) {
//        var message = getMessageOfId(messageId);
//        message.setReadState(READ_STATE);
//        messageRepository.save(message);
    }
}

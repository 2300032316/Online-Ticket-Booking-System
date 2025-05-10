package com.example.demo.Service;

import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
  @Autowired
  private MessageRepository messageRepository;

  public Message saveMessage(Message message) {
    return messageRepository.save(message);
  }

  public List<Message> getConversation(String senderUsername, String receiverUsername) {
    List<Message> sentMessages = messageRepository.findBySenderUsernameAndReceiverUsername(senderUsername,
        receiverUsername);
    List<Message> receivedMessages = messageRepository.findByReceiverUsernameAndSenderUsername(senderUsername,
        receiverUsername);
    sentMessages.addAll(receivedMessages);
    sentMessages.sort((m1, m2) -> m1.getTimestamp().compareTo(m2.getTimestamp())); // Sort by timestamp
    return sentMessages;
  }
}
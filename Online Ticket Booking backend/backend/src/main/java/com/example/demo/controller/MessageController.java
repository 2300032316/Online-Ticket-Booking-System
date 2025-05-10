package com.example.demo.controller;

import com.example.demo.entity.Message;
import com.example.demo.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "http://localhost:5173")
public class MessageController {
  @Autowired
  private MessageService messageService;

  @PostMapping("/send")
  public ResponseEntity<?> sendMessage(@RequestBody Message message) {
    message.setTimestamp(new Timestamp(System.currentTimeMillis()));
    Message savedMessage = messageService.saveMessage(message);
    return ResponseEntity.ok(savedMessage);
  }

  @GetMapping("/conversation")
  public ResponseEntity<List<Message>> getConversation(
      @RequestParam String senderUsername,
      @RequestParam String receiverUsername) {
    List<Message> messages = messageService.getConversation(senderUsername, receiverUsername);
    return ResponseEntity.ok(messages);
  }
}

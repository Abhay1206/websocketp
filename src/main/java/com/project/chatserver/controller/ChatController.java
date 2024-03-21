package com.project.chatserver.controller;

import com.project.chatserver.model.Chat;
import com.project.chatserver.model.MessageRequest;
import com.project.chatserver.model.MessageSent;
import com.project.chatserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ChatController {

   @Autowired
   private MessageService messageService;
  @MessageMapping("/create")
  @SendTo("/topic/public")
   public MessageSent sendMessage(@Payload MessageRequest request){
      messageService.saveMessage(request.getUser_id(),request.getContent());
      return MessageSent.builder().content(request.getContent()).date(new Date()).build();
   }

   @GetMapping("/getAllChats/{user_id}")
   public List<Chat> getAll(@PathVariable Integer user_id){
     return  messageService.getAllChatOfUser(user_id);
   }

   @GetMapping("ll")
    public String hell(){
      return "hlll";
   }
}

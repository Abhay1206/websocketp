package com.project.chatserver.service;

import com.project.chatserver.model.Chat;
import com.project.chatserver.model.User;
import com.project.chatserver.repository.ChatRepository;
import com.project.chatserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRepository chatRepository;
    public void saveMessage(Integer user_id,String content){
        Chat chat= new Chat();
        chat.setMessage(content);
        Optional<User> user=userRepository.findById(user_id);
        user.ifPresent(chat::setUser);
        chatRepository.save(chat);

    }

    public List<Chat> getAllChatOfUser(Integer user_id){
      return  chatRepository.findAllChats(user_id);
    }
}

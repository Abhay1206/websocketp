package com.project.chatserver.repository;

import com.project.chatserver.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,Integer> {

    @Query(value = "select * from chats where user_id= :user_id",nativeQuery = true)
    List<Chat> findAllChats(@Param("user_id") Integer user_id);
}

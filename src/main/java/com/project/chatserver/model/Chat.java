package com.project.chatserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "chats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id
    @SequenceGenerator(name = "chat_sequence", sequenceName = "chat_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_sequence")
    private Integer id;
    private  String message;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}

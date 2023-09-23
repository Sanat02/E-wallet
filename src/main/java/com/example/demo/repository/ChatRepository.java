package com.example.demo.repository;

import com.example.demo.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,Integer> {
    List<Chat> findChatByEmployerIdAndUserId(int employerId,int userId);
}

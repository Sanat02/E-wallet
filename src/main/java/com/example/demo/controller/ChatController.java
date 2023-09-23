package com.example.demo.controller;

import com.example.demo.dto.ChatDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.ChatService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    private final UserService userService;

    @PostMapping("/{employerId}")
    public HttpStatus addMessage(@RequestBody ChatDto chatDto, Authentication auth) {
        chatService.saveMessage(chatDto, auth);
        return HttpStatus.OK;
    }

    @GetMapping("/{employerId}")
    public List<ChatDto> getMessagesByEmployerId(@PathVariable int employerId, Authentication auth) {
        UserDto userDto = userService.mapToUserDto(userService.getUserByEmail(auth.getName()).orElse(null));
        return chatService.getMessagesByEmployerId(userDto.getId(), employerId);
    }

}

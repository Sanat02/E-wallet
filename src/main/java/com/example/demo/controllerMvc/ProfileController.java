package com.example.demo.controllerMvc;

import com.example.demo.dto.TransactionDto;
import com.example.demo.service.TransactionService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
@Slf4j
public class ProfileController {
    private final TransactionService transactionService;
    private final UserService userService;
    @GetMapping
    public String getHomePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<TransactionDto> transactions=transactionService.getUserTransaction(auth.getName());
        model.addAttribute("transactions",transactions);
        model.addAttribute("user",userService.mapToUserDto(userService.getUserByAccount(auth.getName()).get()));
        return "profile";
    }
}

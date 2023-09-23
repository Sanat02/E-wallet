package com.example.demo.controllerMvc;


import com.example.demo.dto.TransactionDto;
import com.example.demo.service.TransactionService;
import com.example.demo.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    private final UserService userService;
    private final TransactionService transactionService;


    @GetMapping
    public String getHomePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        if (auth.getName().equals("anonymousUser")) {
            model.addAttribute("username", null);
        } else {
            model.addAttribute("username", userService.mapToUserDto(userService.getUserByAccount(auth.getName()).get()));

        }
        return "home";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String sendMoney(
            @RequestParam(name = "receiver") String receiver,
            @RequestParam(name = "amount") int amount
    ) {
        if (userService.isAccountExists(receiver)) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (userService.getUserByAccount(auth.getName()).get().getBalance() < amount) {
                return "redirect:/?account=balance";
            } else {
                TransactionDto transactionDto = TransactionDto.builder()
                        .senderAccount(auth.getName())
                        .receiverAccount(receiver)
                        .amount(amount)
                        .build();
                transactionService.save(transactionDto);
                return "redirect:/?account=success";
            }
        } else {
            return "redirect:/?account=user";
        }
    }

    @GetMapping("/forgot")
    public String forgotPassword() {
        return "forget";
    }

    @PostMapping("/forgot")
    public String processForgotPassword(HttpServletRequest request, Model model) {
        try {
            userService.makeResetPasswdLink(request);
            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
        } catch (UsernameNotFoundException | UnsupportedEncodingException e) {
            model.addAttribute("error", e.getMessage());
        } catch (MessagingException e) {
            model.addAttribute("error", "Error while sending email!");
        }
        return "forget";
    }

    @GetMapping("/reset")
    public String showResetPasswordForm(@RequestParam String token, Model model) {
        try {
            userService.getByResetPasswdToken(token);
            model.addAttribute("token", token);
        } catch (UsernameNotFoundException ex) {
            model.addAttribute("error", "Invalid token");
        }
        return "reset";
    }

    @PostMapping("/reset")
    public String processResetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        try {
            var user = userService.getByResetPasswdToken(token);
            userService.updatePassword(user, password);
            model.addAttribute("message", "You have successfully changed your password.");
        } catch (UsernameNotFoundException ex) {
            model.addAttribute("message", "Invalid Token");
        }
        return "message";
    }

    @GetMapping("hashcode")
    public String getAccountCode(@RequestParam(name = "account", defaultValue = "No code") int account,
                                 Model model) {
        model.addAttribute("account", account);
        return "hashcode";

    }
}

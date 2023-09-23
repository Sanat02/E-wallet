package com.example.demo.controllerMvc;


import com.example.demo.dto.UserDto;
import com.example.demo.enums.AccountType;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userService;


    @GetMapping
    public String register() {
        return "registration";
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String addResume(
            @RequestParam(name = "account_name") String accountName,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "account_type") String accountValue,
            @RequestParam(name = "phone_number") String phoneNumber
    ) {
        AccountType accountType;
        if (accountValue.equalsIgnoreCase(AccountType.EMPLOYER.getValue())) {
            accountType = AccountType.EMPLOYER;
        } else {
            accountType = AccountType.JOB_SEEKER;
        }

        if (userService.isUserExist(email).equalsIgnoreCase("1")) {
            return "redirect:/register/error";
        } else {
            UserDto userDto = UserDto.builder()
                    .password(password)
                    .accountName(accountName)
                    .email(email)
                    .phoneNumber(phoneNumber)
                    .accountType(accountType)
                    .build();

            int userId = userService.save(userDto);
            return "redirect:/login";
        }
    }


}

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
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password

    ) {


        if (userService.isUserExist(email).equalsIgnoreCase("1")) {
            return "redirect:/register/error";
        } else {
            UserDto userDto = UserDto.builder()
                    .password(password)
                    .email(email)
                    .accountType(AccountType.USER)
                    .account(String.valueOf(generateUniqueNumber(email)))
                    .build();

            int userId = userService.save(userDto);
            return "redirect:/login";
        }
    }

    public static int generateUniqueNumber(String userEmail) {
        int hashCode = userEmail.hashCode();
        hashCode = Math.abs(hashCode);
        int uniqueNumber = hashCode % 1_000_000;

        if (uniqueNumber < 100_000) {
            uniqueNumber += 100_000;
        }

        return uniqueNumber;
    }


}

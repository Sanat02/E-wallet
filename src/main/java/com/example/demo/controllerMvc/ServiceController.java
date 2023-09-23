package com.example.demo.controllerMvc;

import com.example.demo.dto.PhoneDto;
import com.example.demo.dto.SubscriberDto;
import com.example.demo.dto.UserDto;
import com.example.demo.enums.AccountType;
import com.example.demo.service.PhoneService;
import com.example.demo.service.ServiceService;
import com.example.demo.service.SubscriberService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/service")
public class ServiceController {
    private final ServiceService serviceService;
    private final PhoneService phoneService;
    private final UserService userService;
    private final SubscriberService subscriberService;

    @GetMapping
    public String getServices(Model model) {
        model.addAttribute("services", serviceService.getAllServices());
        return "services";
    }

    @GetMapping("/{serviceId}")
    public String perform(@PathVariable int serviceId, Model model) {
        if (serviceService.getServiceById(serviceId) != null) {
            model.addAttribute("service", serviceService.getServiceById(serviceId));
            return "perform";
        } else {
            return "error";
        }
    }

    @GetMapping("/{serviceId}/subscribe")
    public String subscribe(@PathVariable int serviceId, Model model) {
        if (serviceService.getServiceById(serviceId) != null) {
            model.addAttribute("service", serviceService.getServiceById(serviceId));
            return "subscribe";
        } else {
            return "error";
        }
    }

    @PostMapping("/{serviceId}/subscribe")
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String postSubscribe(
            @RequestParam(name = "phone") String phone,
            @PathVariable int serviceId
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int id = userService.getUserByAccount(auth.getName()).get().getId();
        PhoneDto phoneDto = PhoneDto.builder()
                .phone(phone)
                .userId(id)
                .build();
        phoneService.save(phoneDto);
        return "redirect:/service/" + serviceId;

    }

    @PostMapping("/{serviceId}")
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String withdraw(
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "balance") int balance,
            @PathVariable int serviceId
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int id = userService.getUserByAccount(auth.getName()).get().getId();
        SubscriberDto subscriberDto = SubscriberDto.builder()
                .balance(balance)
                .serviceId(serviceId)
                .phone(phone)
                .build();
        System.out.println("PHONE"+phone);
        subscriberService.save(subscriberDto, auth.getName());
        return "redirect:/profile";

    }


}

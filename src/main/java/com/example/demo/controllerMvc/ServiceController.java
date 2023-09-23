package com.example.demo.controllerMvc;

import com.example.demo.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/service")
public class ServiceController {
    private final ServiceService serviceService;
    @GetMapping
    public String getServices(Model model) {
        model.addAttribute("services",serviceService.getAllServices());
        return "services";
    }
}

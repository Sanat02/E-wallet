package com.example.demo.service;

import com.example.demo.dto.PhoneDto;
import com.example.demo.model.Phone;
import com.example.demo.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;
    private final UserService userService;

    public int save(PhoneDto phoneDto){
        Phone phone=Phone.builder()
                .user(userService.getUserById(phoneDto.getUserId()).get())
                .phone(phoneDto.getPhone())
                .build();
        return phoneRepository.save(phone).getId();
    }
}

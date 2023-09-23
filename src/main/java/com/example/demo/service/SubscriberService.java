package com.example.demo.service;

import com.example.demo.dto.SubscriberDto;
import com.example.demo.model.Subscriber;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.SubscriberRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriberService {
    private final SubscriberRepository subscriberRepository;
    private final ServiceRepository serviceRepository;
    private final UserRepository userRepository;

    public void save(SubscriberDto subscriberDto,String account) {
        Subscriber subscriber = Subscriber.builder()
                .phone(subscriberDto.getPhone())
                .service(serviceRepository.findById(subscriberDto.getServiceId()).get())
                .actDate(new Timestamp(System.currentTimeMillis()))
                .balance(subscriberDto.getBalance())
                .build();
        subscriberRepository.save(subscriber);
        int balance=userRepository.findUserByAccount(account).get().getBalance();
        userRepository.updateBalanceByAccount(account,balance-subscriberDto.getBalance());
    }
}

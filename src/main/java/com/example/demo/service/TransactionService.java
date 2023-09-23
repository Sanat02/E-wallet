package com.example.demo.service;

import com.example.demo.dto.TransactionDto;
import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserService userService;

    public void save(TransactionDto transactionDto) {
        Transaction transaction = Transaction.builder()
                .sender(userService.getUserByAccount(transactionDto.getSenderAccount()).get())
                .receiver(userService.getUserByAccount(transactionDto.getReceiverAccount()).get())
                .amount(transactionDto.getAmount())
                .actDate(new Timestamp(System.currentTimeMillis()))
                .build();
        transactionRepository.save(transaction);
        userService.subMoney(transactionDto.getAmount(), transactionDto.getSenderAccount(),transactionDto.getReceiverAccount());
    }
}

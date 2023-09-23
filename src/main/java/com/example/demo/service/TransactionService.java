package com.example.demo.service;

import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Transaction;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

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
        userService.subMoney(transactionDto.getAmount(), transactionDto.getSenderAccount(), transactionDto.getReceiverAccount());
    }

    public List<TransactionDto> getUserTransaction(String account) {
        User user = userService.getUserByAccount(account).get();
        List<Transaction> transactions = transactionRepository.findTransactionsBySenderIdOrReceiverId(user.getId(), user.getId());
        List<TransactionDto> transactionDtos = transactions.stream()
                .map(e -> TransactionDto.builder()
                        .senderAccount(e.getSender().getAccount())
                        .receiverAccount(e.getReceiver().getAccount())
                        .amount(e.getAmount())
                        .actDate(e.getActDate())
                        .build()
                ).collect(Collectors.toList());
        return transactionDtos;

    }
}

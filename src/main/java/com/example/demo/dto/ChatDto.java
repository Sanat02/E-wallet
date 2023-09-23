package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ChatDto {
    private int id;
    private int userId;
    private int employerId;
    private String message;
    private LocalDate messageDate;
}

package com.example.demo.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneDto {
    private int id;
    private int userId;
    private String phone;
}

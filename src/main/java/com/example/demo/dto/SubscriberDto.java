package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class SubscriberDto {
    private int id;
    private int serviceId;
    private String phone;
    private int balance;

}

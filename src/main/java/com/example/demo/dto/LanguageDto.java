package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageDto {
    private int id;
    private UserDto user;
    private String language;
}

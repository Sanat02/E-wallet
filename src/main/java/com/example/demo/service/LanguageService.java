package com.example.demo.service;

import com.example.demo.dto.LanguageDto;
import com.example.demo.model.Language;
import com.example.demo.repository.LanguageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;
    private final UserService userService;

    @Transactional
    public void save(LanguageDto languageDto) {
        Language language = Language.builder()
                .language(languageDto.getLanguage())
                .user(userService.getUserById(languageDto.getUser().getId()).get())
                .build();

        if (languageRepository.existsByUserId(languageDto.getUser().getId())) {
            languageRepository.deleteByUserId(languageDto.getUser().getId());
        }
        languageRepository.save(language);
    }
}

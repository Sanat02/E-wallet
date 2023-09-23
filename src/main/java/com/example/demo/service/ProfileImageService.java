package com.example.demo.service;


import com.example.demo.dto.ProfileImageDto;
import com.example.demo.model.ProfileImage;
import com.example.demo.repository.ProfileImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileImageService {
    private static final String SUB_DIR = "/images";
    private final FileService fileService;
    private final ProfileImageRepository profileImageRepository;


    public void uploadImage(ProfileImageDto profileImageDto) {
        String fileName = fileService.saveUploadedFile(profileImageDto.getFile(), SUB_DIR);
        ProfileImage pi = ProfileImage.builder()
                .userId(profileImageDto.getUserId())
                .fileName(fileName)
                .id(profileImageDto.getId())
                .build();
       ProfileImage savedPhoto=profileImageRepository.save(pi);
        log.info("Image saved:" + pi.getFileName());

    }

    public ResponseEntity<?> downloadImage(int imageId) {
        String filename;
        try {
            ProfileImage profileImage=profileImageRepository.findById(imageId).get();
            filename = profileImage.getFileName();
        } catch (NullPointerException e) {
            throw new NoSuchElementException("Image not found!");
        }
        return fileService.getOutputFile(filename, "/images", MediaType.IMAGE_PNG);
    }

    public String getImageByUserId(int userId) {
        ProfileImage profileImage=profileImageRepository.findByUserId(userId);
        if (profileImage == null) {
            return null;
        }
        var value=ProfileImageDto.builder()
                .userId(profileImage.getUserId())
                .fileName("/"+profileImage.getFileName())
                .build();
        return value.getFileName();
    }
    public ResponseEntity<?> getImageByUsId(int userId) {
        ProfileImage profileImage =profileImageRepository.findByUserId(userId);
        return fileService.getOutputFile(profileImage.getFileName(), SUB_DIR, MediaType.IMAGE_JPEG);
    }
}

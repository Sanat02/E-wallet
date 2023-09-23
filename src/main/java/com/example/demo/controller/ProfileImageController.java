package com.example.demo.controller;

import com.example.demo.dto.ProfileImageDto;
import com.example.demo.service.ProfileImageService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profileimg")
@RequiredArgsConstructor
public class ProfileImageController {
    private final ProfileImageService profileImageService;
    private final UserService userService;

    @GetMapping("/download/{imageId}")
    public ResponseEntity<?> downloadImage(@PathVariable int imageId){
        return profileImageService.downloadImage(imageId);
    }

    @PostMapping("/upload")
    public HttpStatus uploadImage(ProfileImageDto profileImageDto){
        profileImageService.uploadImage(profileImageDto);
        return HttpStatus.OK;

    }
    @GetMapping
    public ResponseEntity<?> getImageByUserId() {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        return profileImageService.getImageByUsId(userService.mapToUserDto(userService.getUserByEmail(auth.getName()).get()).getId());
    }
}

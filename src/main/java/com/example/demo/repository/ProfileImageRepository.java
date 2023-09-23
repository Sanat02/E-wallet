package com.example.demo.repository;

import com.example.demo.model.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileImageRepository extends JpaRepository<ProfileImage,Integer> {
    ProfileImage findByUserId(int userId);
}

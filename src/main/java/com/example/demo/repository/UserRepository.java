package com.example.demo.repository;

import com.example.demo.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByEmail(String email);
    Optional<User> findByResetPasswordToken(String token);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.accountName = :accountName, u.email = :email, u.password = :password, u.phoneNumber = :phoneNumber WHERE u.id = :id")
    void updateUser(@Param("id") int id, @Param("accountName") String accountName, @Param("email") String email, @Param("password") String password, @Param("phoneNumber") String phoneNumber);
}

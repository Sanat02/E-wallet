package com.example.demo.repository;

import com.example.demo.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByAccount(String account);

    Optional<User> findByResetPasswordToken(String token);

    Boolean existsByAccount(String account);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.balance = :newBalance WHERE u.account = :accountValue")
    int updateBalanceByAccount(@Param("accountValue") String accountValue, @Param("newBalance") int newBalance);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.balance = :newBalance WHERE u.id = :accountValue")
    int updateBalanceById(@Param("accountValue") int accountValue, @Param("newBalance") int newBalance);
}

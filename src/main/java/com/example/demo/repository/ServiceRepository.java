package com.example.demo.repository;

import com.example.demo.model.ServiceL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceL,Integer> {
}

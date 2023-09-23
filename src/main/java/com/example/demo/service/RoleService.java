package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class RoleService {
    private final RoleRepository roleRepository;

    public Role getRoleById(long id){
        return roleRepository.findById((int) id).get();
    }
}

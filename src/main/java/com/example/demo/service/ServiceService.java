package com.example.demo.service;

import com.example.demo.dto.ServiceDto;
import com.example.demo.model.ServiceL;
import com.example.demo.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.security.Provider;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public List<ServiceDto> getAllServices() {
        List<ServiceL> services = serviceRepository.findAll();
        List<ServiceDto> serviceDtos = services.stream()
                .map(e -> ServiceDto.builder()
                        .id(e.getId())
                        .service(e.getService())
                        .build()
                ).collect(Collectors.toList());
        return serviceDtos;
    }

    public ServiceDto getServiceById(int serviceId) {
        ServiceL service = serviceRepository.findById(serviceId).orElse(null);
        if (service == null) {
            return null;
        }
        return ServiceDto.builder()
                .id(service.getId())
                .service(service.getService())
                .build();
    }
}

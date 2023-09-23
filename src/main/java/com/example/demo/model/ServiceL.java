package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "services")
public class ServiceL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String service;

    @OneToMany(fetch= FetchType.LAZY,mappedBy = "service")
    private List<Subscriber> subscribers;
}

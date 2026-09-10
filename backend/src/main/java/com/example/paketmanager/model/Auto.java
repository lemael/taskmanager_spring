package com.example.paketmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "autos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String mainContact;

    private String city;

    private String contract; // ex: VIP Express, Standard Pro

    private String monthlyVolume;

}
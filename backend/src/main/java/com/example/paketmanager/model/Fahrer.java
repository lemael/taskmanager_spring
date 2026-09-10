package com.example.paketmanager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fahrer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fahrer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String plateNumber; // ex: DO-PM 102

    private String model; // ex: MB Sprinter 316

    private String maxCapacity; // ex: 1200 kg / 10 m³

    private String mileage; // ex: 4500 km

    private String tuvInspection; // ex: 10/2026

    @Enumerated(EnumType.STRING)
    private FahrerStatus status;

    public enum FahrerStatus {
        IM_DIENST,
        VERFÜGBAR,
        INSPEKTION,
        DEFEKT
    }
}
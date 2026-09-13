package com.example.paketmanager.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(unique = true, nullable = false)
    private String plateNumber; // ex: DO-PM 102

    private String model; // ex: MB Sprinter 316

    private String maxCapacity; // ex: 1200 kg / 10 m³

    private String mileage; // ex: 4500 km

    private String tuvInspection; // ex: 10/2026

    @Enumerated(EnumType.STRING)
    private AutoStatus status;

    public enum AutoStatus {
        IM_DIENST,
        VERFÜGBAR,
        INSPEKTION,
        DEFEKT
    }

    public void setAutoId(Long autoId) {
        this.id = autoId;
    }

    @JsonIgnore
    public Long getAutoId() {
        return this.id;
    }
}
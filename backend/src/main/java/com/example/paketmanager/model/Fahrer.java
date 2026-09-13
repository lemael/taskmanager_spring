package com.example.paketmanager.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(nullable = false)
    private String name;

    private String licenseClass; // ex: C, CE

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private FahrerStatus status;

    public enum FahrerStatus {
        IN_AUSLIEFERUNG,
        PAUSIERT,
        VERFÜGBAR,
        URLAUB
    }

    public void setFahrerId(Long fahrerId) {
        this.id = fahrerId;
    }

    @JsonIgnore
    public Long getFahrerId() {
        return this.id;
    }
}
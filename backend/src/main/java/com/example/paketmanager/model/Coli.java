package com.example.paketmanager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "colis")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coli {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String coliNumber; // ex: PKG-8821

    private String recipient; // ex: München (80331)

    private String formatAndWeight; // ex: 1.2 kg (S)

    @Enumerated(EnumType.STRING)
    private ColiStatus status;

    @ManyToOne
    @JoinColumn(name = "kunde_id")
    private Kunde kunde;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    public enum ColiStatus {
        AUSSTEHEND,
        IN_ARBEIT,
        GELIEFERT,
        ANOMALIE
    }
}
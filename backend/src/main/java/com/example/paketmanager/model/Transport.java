package com.example.paketmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "transports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String transportNumber; // ex: TR-1023

    private String zone; // ex: Dortmund-Nord

    private Integer parcelsCount;

    private Integer deliveredCount;

    @ManyToOne
    @JoinColumn(name = "fahrer_id")
    private Fahrer driver;

    @ManyToOne
    @JoinColumn(name = "auto_id")
    private Auto vehicle;

    @Enumerated(EnumType.STRING)
    private TransportStatus status;

    @OneToMany(mappedBy = "transport")
    private List<Coli> colis;

    public enum TransportStatus {
        IN_TRANSIT,
        PICKED_UP,
        DELIVERED,
        DELAYED
    }
}
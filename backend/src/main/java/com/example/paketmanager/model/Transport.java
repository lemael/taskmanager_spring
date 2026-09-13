package com.example.paketmanager.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    private Integer colisCount;

    private Integer deliveredCount;

    @ManyToOne
    @JoinColumn(name = "fahrer_id")
    @JsonIgnoreProperties("transports")
    private Fahrer fahrer;

    @ManyToOne
    @JoinColumn(name = "auto_id")
    @JsonIgnoreProperties("transports")
    private Auto auto;

    @Enumerated(EnumType.STRING)
    private TransportStatus status;

    @OneToMany(mappedBy = "transport")
    @JsonIgnoreProperties("transport")
    private List<Coli> colis;

    public enum TransportStatus {
        IN_TRANSIT,
        PICKED_UP,
        DELIVERED,
        DELAYED
    }

    public void setTransportId(Long transportId) {
        this.id = transportId;
    }
    @JsonIgnore
    public Long getTransportId() {
        return this.id;
    }
}
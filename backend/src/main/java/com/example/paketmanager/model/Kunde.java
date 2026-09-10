package com.example.paketmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "kunden")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kundeId;

    @Column(nullable = false)
    private String name;

    private String mainContact;

    private String city;

    private String contract; // ex: VIP Express, Standard Pro

    private String monthlyVolume;

    @OneToMany(mappedBy = "kunde", cascade = CascadeType.ALL)
    private List<Coli> colis;
}
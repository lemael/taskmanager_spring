package com.example.paketmanager.repository;

import com.example.paketmanager.model.Coli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColiRepository extends JpaRepository<Coli, Long> {
    Optional<Coli> findByColiNumber(String coliNumber);
    List<Coli> findByStatus(Coli.ColiStatus status);
    List<Coli> findByKundeKundeId(Long kundeId);
    List<Coli> findByTransportId(Long transportId);
}
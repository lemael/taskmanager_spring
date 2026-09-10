package com.example.paketmanager.service;

import com.example.paketmanager.model.Coli;
import com.example.paketmanager.repository.ColiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColiService {

    private final ColiRepository coliRepository;

    public ColiService(ColiRepository coliRepository) {
        this.coliRepository = coliRepository;
    }

    public List<Coli> getAllColis() {
        return coliRepository.findAll();
    }

    public Optional<Coli> getColiById(Long id) {
        return coliRepository.findById(id);
    }

    public Optional<Coli> getColiByNumber(String coliNumber) {
        return coliRepository.findByColiNumber(coliNumber);
    }

    public List<Coli> getColisByStatus(Coli.ColiStatus status) {
        return coliRepository.findByStatus(status);
    }

    public List<Coli> getColisByKundeId(Long kundeId) {
        return coliRepository.findByKundeKundeId(kundeId);
    }
    public List<Coli> getColisByTransportId(Long transportId) {
        return coliRepository.findByTransportId(transportId);
    }
    public Coli saveColi(Coli coli) {
        return coliRepository.save(coli);
    }

    public void deleteColi(Long id) {
        coliRepository.deleteById(id);
    }
}
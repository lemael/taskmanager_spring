package com.example.paketmanager.service;

import com.example.paketmanager.model.Kunde;
import com.example.paketmanager.repository.KundeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KundeService {

    private final KundeRepository kundeRepository;

    public KundeService(KundeRepository kundeRepository) {
        this.kundeRepository = kundeRepository;
    }

    public List<Kunde> getAllKunden() {
        return kundeRepository.findAll();
    }

    public Optional<Kunde> getKundeById(Long id) {
        return kundeRepository.findById(id);
    }

    public Kunde saveKunde(Kunde kunde) {
        return kundeRepository.save(kunde);
    }

    public void deleteKunde(Long id) {
        kundeRepository.deleteById(id);
    }
}
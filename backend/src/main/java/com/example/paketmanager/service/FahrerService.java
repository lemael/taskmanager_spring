package com.example.paketmanager.service;

import com.example.paketmanager.model.Fahrer;
import com.example.paketmanager.repository.FahrerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FahrerService {

    private final FahrerRepository fahrerRepository;

    public FahrerService(FahrerRepository fahrerRepository) {
        this.fahrerRepository = fahrerRepository;
    }

    public List<Fahrer> getAllFahrer() {
        return fahrerRepository.findAll();
    }

    public Optional<Fahrer> getFahrerById(Long id) {
        return fahrerRepository.findById(id);
    }

    public List<Fahrer> getFahrerByStatus(Fahrer.FahrerStatus status) {
        return fahrerRepository.findByStatus(status);
    }

    public Fahrer saveFahrer(Fahrer fahrer) {
        return fahrerRepository.save(fahrer);
    }

    public void deleteFahrer(Long id) {
        fahrerRepository.deleteById(id);
    }
}
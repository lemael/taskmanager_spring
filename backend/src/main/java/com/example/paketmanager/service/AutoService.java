package com.example.paketmanager.service;

import com.example.paketmanager.model.Auto;
import com.example.paketmanager.repository.AutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoService {

    private final AutoRepository autoRepository;

    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public List<Auto> getAllAutos() {
        return autoRepository.findAll();
    }

    public Optional<Auto> getAutoById(Long id) {
        return autoRepository.findById(id);
    }

    public List<Auto> getAutosByContract(String contract) {
        return autoRepository.findByContract(contract);
    }

    public Auto saveAuto(Auto auto) {
        return autoRepository.save(auto);
    }

    public void deleteAuto(Long id) {
        autoRepository.deleteById(id);
    }
}
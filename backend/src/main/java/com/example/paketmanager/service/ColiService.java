package com.example.paketmanager.service;

import com.example.paketmanager.dto.ColiDto;
import com.example.paketmanager.dto.DtoMapper;
import com.example.paketmanager.model.Coli;
import com.example.paketmanager.repository.ColiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColiService {

    private final ColiRepository coliRepository;
    private final DtoMapper dtoMapper;

    public ColiService(ColiRepository coliRepository, DtoMapper dtoMapper) {
        this.coliRepository = coliRepository;
        this.dtoMapper = dtoMapper;
    }

    public List<ColiDto> getAllColis() {
        return coliRepository.findAll()
                .stream()
                .map(dtoMapper::toColiDto)
                .collect(Collectors.toList());
    }

    public Optional<ColiDto> getColiById(Long id) {
        return coliRepository.findById(id)
                .map(dtoMapper::toColiDto);
    }

    public Optional<ColiDto> getColiByNumber(String coliNumber) {
        return coliRepository.findByColiNumber(coliNumber)
                .map(dtoMapper::toColiDto);
    }

    public List<ColiDto> getColisByStatus(Coli.ColiStatus status) {
        return coliRepository.findByStatus(status)
                .stream()
                .map(dtoMapper::toColiDto)
                .collect(Collectors.toList());
    }

    public List<ColiDto> getColisByKundeId(Long kundeId) {
        return coliRepository.findByKundeId(kundeId)
                .stream()
                .map(dtoMapper::toColiDto)
                .collect(Collectors.toList());
    }
    public List<ColiDto> getColisByTransportId(Long transportId) {
        return coliRepository.findByTransportId(transportId)
                .stream()
                .map(dtoMapper::toColiDto)
                .collect(Collectors.toList());
    }
    public ColiDto saveColi(Coli coli) {
        return dtoMapper.toColiDto(coliRepository.save(coli));
    }

    public void deleteColi(Long id) {
        coliRepository.deleteById(id);
    }
}
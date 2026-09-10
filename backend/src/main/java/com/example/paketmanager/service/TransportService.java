package com.example.paketmanager.service;

import com.example.paketmanager.model.Transport;
import com.example.paketmanager.repository.TransportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportService {

    private final TransportRepository transportRepository;

    public TransportService(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    public List<Transport> getAllTransports() {
        return transportRepository.findAll();
    }

    public Optional<Transport> getTransportById(Long id) {
        return transportRepository.findById(id);
    }

    public Optional<Transport> getTransportByNumber(String transportNumber) {
        return transportRepository.findByTransportNumber(transportNumber);
    }

    public List<Transport> getTransportsByStatus(Transport.TransportStatus status) {
        return transportRepository.findByStatus(status);
    }

    public Transport saveTransport(Transport transport) {
        return transportRepository.save(transport);
    }

    public void deleteTransport(Long id) {
        transportRepository.deleteById(id);
    }
}
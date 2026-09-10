package com.example.paketmanager.controller;

import com.example.paketmanager.model.Kunde;
import com.example.paketmanager.service.KundeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kunden")
@CrossOrigin(origins = "*")
public class KundeController {

    private final KundeService kundeService;

    public KundeController(KundeService kundeService) {
        this.kundeService = kundeService;
    }

    @GetMapping
    public ResponseEntity<List<Kunde>> getAllKunden() {
        return ResponseEntity.ok(kundeService.getAllKunden());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kunde> getKundeById(@PathVariable Long id) {
        return kundeService.getKundeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Kunde> createKunde(@RequestBody Kunde kunde) {
        return ResponseEntity.status(HttpStatus.CREATED).body(kundeService.saveKunde(kunde));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kunde> updateKunde(@PathVariable Long id, @RequestBody Kunde kunde) {
        return kundeService.getKundeById(id)
                .map(existing -> {
                    kunde.setKundeId(id);
                    return ResponseEntity.ok(kundeService.saveKunde(kunde));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKunde(@PathVariable Long id) {
        if (kundeService.getKundeById(id).isPresent()) {
            kundeService.deleteKunde(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
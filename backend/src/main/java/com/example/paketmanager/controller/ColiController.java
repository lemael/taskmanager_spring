package com.example.paketmanager.controller;

import com.example.paketmanager.model.Coli;
import com.example.paketmanager.service.ColiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colis")
@CrossOrigin(origins = "*")
public class ColiController {

    private final ColiService coliService;

    public ColiController(ColiService coliService) {
        this.coliService = coliService;
    }

    @GetMapping
    public ResponseEntity<List<Coli>> getAllColis() {
        return ResponseEntity.ok(coliService.getAllColis());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coli> getColiById(@PathVariable Long id) {
        return coliService.getColiById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Coli> createColi(@RequestBody Coli coli) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coliService.saveColi(coli));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coli> updateColi(@PathVariable Long id, @RequestBody Coli coli) {
        return coliService.getColiById(id)
                .map(existing -> {
                    coli.setId(id);
                    return ResponseEntity.ok(coliService.saveColi(coli));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColi(@PathVariable Long id) {
        if (coliService.getColiById(id).isPresent()) {
            coliService.deleteColi(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
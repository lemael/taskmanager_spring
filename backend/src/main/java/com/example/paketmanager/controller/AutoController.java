package com.example.paketmanager.controller;

import com.example.paketmanager.model.Auto;
import com.example.paketmanager.service.AutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autos")
@CrossOrigin(origins = "*")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public ResponseEntity<List<Auto>> getAllAutos() {
        return ResponseEntity.ok(autoService.getAllAutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auto> getAutoById(@PathVariable Long id) {
        return autoService.getAutoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Auto> createAuto(@RequestBody Auto auto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autoService.saveAuto(auto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Auto> updateAuto(@PathVariable Long id, @RequestBody Auto auto) {
        return autoService.getAutoById(id)
                .map(existing -> {
                    auto.setId(id);
                    return ResponseEntity.ok(autoService.saveAuto(auto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuto(@PathVariable Long id) {
        if (autoService.getAutoById(id).isPresent()) {
            autoService.deleteAuto(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
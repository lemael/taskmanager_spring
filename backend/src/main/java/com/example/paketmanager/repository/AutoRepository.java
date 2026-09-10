package com.example.paketmanager.repository;

import com.example.paketmanager.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {
List<Auto> findByName(String name);
    List<Auto> findByCity(String city);
    List<Auto> findByContract(String contract);
}
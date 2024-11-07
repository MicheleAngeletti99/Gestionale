package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.Oggetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OggettoRepository extends JpaRepository<Oggetto, Long> {
}

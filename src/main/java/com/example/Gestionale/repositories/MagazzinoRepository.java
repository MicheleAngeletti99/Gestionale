package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.Magazzino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazzinoRepository extends JpaRepository<Magazzino,Long> {
}

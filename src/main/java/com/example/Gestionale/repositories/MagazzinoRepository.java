package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.Magazzino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazzinoRepository extends JpaRepository<Magazzino,Long> {

}

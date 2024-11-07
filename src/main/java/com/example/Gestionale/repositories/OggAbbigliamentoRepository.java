package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.OggAbbigliamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OggAbbigliamentoRepository extends JpaRepository<OggAbbigliamento, Long> {
}

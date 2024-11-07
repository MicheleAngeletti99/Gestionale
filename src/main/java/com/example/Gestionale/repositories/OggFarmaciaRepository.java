package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.OggFarmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OggFarmaciaRepository extends JpaRepository<OggFarmacia, Long> {
}

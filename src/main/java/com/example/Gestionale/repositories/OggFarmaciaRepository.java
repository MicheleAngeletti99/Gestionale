package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.OggFarmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OggFarmaciaRepository extends JpaRepository<OggFarmacia, Long> {

    @Modifying
    @Query(value = "DELETE FROM ogg_farmacia WHERE id_magazzino = :magazzinoId", nativeQuery = true)
    void deleteOggFarmaciaByMagazzinoId(@Param("magazzinoId") Long magazzinoId);
}

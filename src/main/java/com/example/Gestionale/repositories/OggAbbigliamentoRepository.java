package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.OggAbbigliamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OggAbbigliamentoRepository extends JpaRepository<OggAbbigliamento, Long> {

    @Modifying
    @Query(value = "DELETE FROM ogg_abbigliamento WHERE id_magazzino = :magazzinoId", nativeQuery = true)
    void deleteOggAbbigliamentoByMagazzinoId(@Param("magazzinoId") Long magazzinoId);
}

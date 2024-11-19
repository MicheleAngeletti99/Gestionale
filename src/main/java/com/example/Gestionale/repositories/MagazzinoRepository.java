package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.Magazzino;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazzinoRepository extends JpaRepository<Magazzino,Long> {

    @Modifying
    @Query(value = "DELETE FROM ogg_farmacia WHERE id_magazzino = :magazzinoId", nativeQuery = true)
    void deleteOggFarmaciaByMagazzinoId(@Param("magazzinoId") Long magazzinoId);

    @Modifying
    @Query(value = "DELETE FROM ogg_pub WHERE id_magazzino = :magazzinoId", nativeQuery = true)
    void deleteOggPubByMagazzinoId(@Param("magazzinoId") Long magazzinoId);

    @Modifying
    @Query(value = "DELETE FROM ogg_abbigliamento WHERE id_magazzino = :magazzinoId", nativeQuery = true)
    void deleteOggAbbigliamentoByMagazzinoId(@Param("magazzinoId") Long magazzinoId);

    @Modifying
    @Query(value = "DELETE FROM magazzini WHERE id = :magazzinoId", nativeQuery = true)
    void deleteMagazzinoById(@Param("magazzinoId") Long magazzinoId);
}

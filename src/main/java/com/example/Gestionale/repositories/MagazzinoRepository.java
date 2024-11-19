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
    @Query(value = "DELETE FROM magazzini WHERE id_utente = :utenteId", nativeQuery = true)
    void deleteMagazzinoByUtenteId(@Param("utenteId") Long utenteId);

}

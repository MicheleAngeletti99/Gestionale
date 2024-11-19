package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    @Modifying
    @Query(value = "DELETE FROM magazzini WHERE id_utente = :utenteId", nativeQuery = true)
    void deleteMagazzinoByUtenteId(@Param("utenteId") Long utenteId);

    @Modifying
    @Query(value = "DELETE FROM utenti WHERE id = :utenteId", nativeQuery = true)
    void deleteUtenteById(@Param("utenteId") Long utenteId);
}
package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.Magazzino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagazzinoRepository extends JpaRepository<Magazzino,Long> {

    @Modifying
    @Query(value = "DELETE FROM magazzini WHERE id_utente = :utenteId", nativeQuery = true)
    void deleteMagazzinoByUtenteId(@Param("utenteId") Long utenteId);

    /**
     * Searches warehouses corresponding to the given fields.
     *
     * @param nomeAttivita a String contained in the name to be searched.
     * @param indirizzo a String contained in the address to be searched.
     * @param tipologiaAttivita the exact type to be searched.
     * @return a List with the found warehouses.
     */
    @Query(value = "select * from magazzini m " +
            "where (:nome is null or m.nome_attivita like %:nome%) " +
            "and (:indirizzo is null or m.indirizzo like %:indirizzo%) " +
            "and (:tipo is null or m.tipologia_attivita like :tipo)", nativeQuery = true)
    List<Magazzino> findByFields(@Param("nome") String nomeAttivita,
                                 @Param("indirizzo") String indirizzo,
                                 @Param("tipo") String tipologiaAttivita);
}

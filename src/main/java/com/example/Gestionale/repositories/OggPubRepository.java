package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.OggPub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OggPubRepository extends JpaRepository<OggPub, Long> {

    @Modifying
    @Query(value = "DELETE FROM ogg_pub WHERE id_magazzino = :magazzinoId", nativeQuery = true)
    void deleteOggPubByMagazzinoId(@Param("magazzinoId") Long magazzinoId);

    /**
     * Searches items in ogg_pub table corresponding to the given fields.
     *
     * @param nome a String contained in the name to be searched.
     * @param prezzo the max price to be searched.
     * @param quantita the min number of items in stock.
     * @param descrizione a String contained in the description to be searched.
     * @param scadenza the earliest expiring date to be searched.
     * @param tipologia the exact type to be searched.
     * @return a List with the found items.
     */
    @Query(value = "select * from ogg_pub o " +
            "where (:nome is null or o.nome like %:nome%) " +
            "and (:prezzo is null or o.prezzo <= :prezzo) " +
            "and (:quantita is null or o.quantita >= :quantita) " +
            "and (:descrizione is null or o.descrizione like %:descrizione%) " +
            "and (:scadenza is null or o.scadenza >= :scadenza) " +
            "and (:tipo is null or o.tipologia like :tipo)", nativeQuery = true)
    List<OggPub> findByFields(@Param("nome") String nome,
                              @Param("prezzo") Double prezzo,
                              @Param("quantita") Integer quantita,
                              @Param("descrizione") String descrizione,
                              @Param("scadenza") LocalDate scadenza,
                              @Param("tipo") String tipologia);
}

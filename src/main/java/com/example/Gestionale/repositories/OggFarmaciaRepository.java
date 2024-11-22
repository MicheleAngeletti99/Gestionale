package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.OggFarmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OggFarmaciaRepository extends JpaRepository<OggFarmacia, Long> {

    @Modifying
    @Query(value = "DELETE FROM ogg_farmacia WHERE id_magazzino = :magazzinoId", nativeQuery = true)
    void deleteOggFarmaciaByMagazzinoId(@Param("magazzinoId") Long magazzinoId);

    /**
     * Searches items in ogg_farmacia table corresponding to the given fields.
     *
     * @param nome a String contained in the name to be searched.
     * @param prezzo the max price to be searched.
     * @param quantita the min number of items in stock.
     * @param descrizione a String contained in the description to be searched.
     * @param conRicetta if the item requires a recipe or not.
     * @param scadenza the earliest expiring date to be searched.
     * @param codiceIdentificativo the exact code to be searched.
     * @return a List with the found items.
     */
    @Query(value = "select * from ogg_farmacia o " +
            "where (:nome is null or o.nome like %:nome%) " +
            "and (:prezzo is null or o.prezzo <= :prezzo) " +
            "and (:quantita is null or o.quantita >= :quantita) " +
            "and (:descrizione is null or o.descrizione like %:descrizione%) " +
            "and (:conRicetta is null or o.con_ricetta = :conRicetta) " +
            "and (:scadenza is null or o.scadenza >= :scadenza) " +
            "and (:codice is null or o.codice_identificativo like :codice)", nativeQuery = true)
    List<OggFarmacia> findByFields(@Param("nome") String nome,
                                   @Param("prezzo") Double prezzo,
                                   @Param("quantita") Integer quantita,
                                   @Param("descrizione") String descrizione,
                                   @Param("conRicetta") Boolean conRicetta,
                                   @Param("scadenza") LocalDate scadenza,
                                   @Param("codice") String codiceIdentificativo);
}

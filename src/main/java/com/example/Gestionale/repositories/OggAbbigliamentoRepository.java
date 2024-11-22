package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.OggAbbigliamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OggAbbigliamentoRepository extends JpaRepository<OggAbbigliamento, Long> {

    @Modifying
    @Query(value = "DELETE FROM ogg_abbigliamento WHERE id_magazzino = :magazzinoId", nativeQuery = true)
    void deleteOggAbbigliamentoByMagazzinoId(@Param("magazzinoId") Long magazzinoId);

    /**
     * Searches items in ogg_abbigliamento table corresponding to the given fields.
     *
     * @param nome a String contained in the name to be searched.
     * @param prezzo the max price to be searched.
     * @param quantita the min number of items in stock.
     * @param descrizione a String contained in the description to be searched.
     * @param marca a String contained in the brand to be searched.
     * @param taglia the exact size to be searched.
     * @param tipologia the exact type to be searched.
     * @return a List with the found items.
     */
    @Query(value = "select * from ogg_abbigliamento o " +
            "where (:nome is null or o.nome like %:nome%) " +
            "and (:prezzo is null or o.prezzo <= :prezzo) " +
            "and (:quantita is null or o.quantita >= :quantita) " +
            "and (:descrizione is null or o.descrizione like %:descrizione%) " +
            "and (:marca is null or o.marca like %:marca%) " +
            "and (:taglia is null or o.taglia like :taglia) " +
            "and (:tipo is null or o.tipologia like :tipo)", nativeQuery = true)
    List<OggAbbigliamento> findByFields(@Param("nome") String nome,
                                        @Param("prezzo") Double prezzo,
                                        @Param("quantita") Integer quantita,
                                        @Param("descrizione") String descrizione,
                                        @Param("marca") String marca,
                                        @Param("taglia") String taglia,
                                        @Param("tipo") String tipologia);

}

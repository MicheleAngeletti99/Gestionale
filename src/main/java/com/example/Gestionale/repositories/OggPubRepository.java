package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.OggPub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OggPubRepository extends JpaRepository<OggPub, Long> {

    @Modifying
    @Query(value = "DELETE FROM ogg_pub WHERE id_magazzino = :magazzinoId", nativeQuery = true)
    void deleteOggPubByMagazzinoId(@Param("magazzinoId") Long magazzinoId);
}

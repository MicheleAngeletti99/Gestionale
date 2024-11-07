package com.example.Gestionale.repositories;

import com.example.Gestionale.entities.OggPub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OggPubRepository extends JpaRepository<OggPub, Long> {
}

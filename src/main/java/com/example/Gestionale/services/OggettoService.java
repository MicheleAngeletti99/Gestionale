package com.example.Gestionale.services;

import com.example.Gestionale.entities.Oggetto;
import com.example.Gestionale.repositories.OggettoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OggettoService {
    @Autowired
    private OggettoRepository oggettoRepository;

    public Oggetto create(Oggetto oggetto) {
        return oggettoRepository.save(oggetto);
    }

    public List<Oggetto> readAll() {
        return oggettoRepository.findAll();
    }

    public Optional<Oggetto> update(Long id, Oggetto oggetto) {
        Optional<Oggetto> optionalOggetto = oggettoRepository.findById(id);
        if (optionalOggetto.isPresent()) {
            Oggetto updateOggetto = optionalOggetto.get();

            updateOggetto.setNome(oggetto.getNome());

            return Optional.of(oggettoRepository.save(updateOggetto));
        } else {
            return Optional.empty();
        }
    }

    public void delete(Long id) {
        oggettoRepository.deleteById(id);
    }
}

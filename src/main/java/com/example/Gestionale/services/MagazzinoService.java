package com.example.Gestionale.services;

import com.example.Gestionale.entities.Magazzino;
import com.example.Gestionale.repositories.MagazzinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MagazzinoService {

    @Autowired
    private MagazzinoRepository magazzinoRepository;

    public List<Magazzino> readAll(){
        return magazzinoRepository.findAll();
    }

    public Optional<Magazzino> readById(Long id){
        return magazzinoRepository.findById(id);
    }

    public Magazzino create(Magazzino magazzino){
        return magazzinoRepository.save(magazzino);
    }

    public Optional<Magazzino> update(Long id, Magazzino magazzino){
        Optional<Magazzino> magazzinoOptional = magazzinoRepository.findById(id);
        if (magazzinoOptional.isPresent()){
            Magazzino magazzinoTrovato = magazzinoOptional.get();
            magazzinoTrovato.setNomeAttivita(magazzino.getNomeAttivita());
            magazzinoTrovato.setPassword(magazzinoTrovato.getPassword());
            magazzinoTrovato.setTipologia(magazzinoTrovato.getTipologia());
            magazzinoTrovato.setIndirizzo(magazzinoTrovato.getIndirizzo());
            magazzinoTrovato.setEmail(magazzinoTrovato.getEmail());

            return Optional.of(magazzinoRepository.save(magazzinoTrovato));
        }
        return Optional.empty();
    }

    public boolean delete(Long id){
        Optional<Magazzino> magazzinoOptional = magazzinoRepository.findById(id);
        if (magazzinoOptional.isPresent()){
            magazzinoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

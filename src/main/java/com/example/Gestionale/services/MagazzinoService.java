package com.example.Gestionale.services;

import com.example.Gestionale.entities.Magazzino;
import com.example.Gestionale.entities.Utente;
import com.example.Gestionale.repositories.MagazzinoRepository;
import com.example.Gestionale.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MagazzinoService {

    @Autowired
    private MagazzinoRepository magazzinoRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    /**
     * Retrieves a list of all Magazzino entries from the repository.
     * @return a list of all warehouses
     */
    public List<Magazzino> readAll(){
        return magazzinoRepository.findAll();
    }

    /**
     * Retrieves a Magazzino by its ID if it exists.
     * @param id the ID of the Magazzino to retrieve
     * @return an Optional containing the found Magazzino or empty if not found
     */
    public Optional<Magazzino> readById(Long id){
        return magazzinoRepository.findById(id);
    }

    /**
     * Creates a new Magazzino entry in the repository.
     * @param magazzino the Magazzino object to save
     * @param idUtente the ID of Utente to associate with the Magazzino.
     * @return the created Magazzino object
     */
    public Optional<Magazzino> create(Long idUtente, Magazzino magazzino){
        Optional<Utente> optionalUtente = utenteRepository.findById(idUtente);
        if (optionalUtente.isPresent()){
            Utente utente = optionalUtente.get();
            magazzino.setUtente(utente);
            Magazzino savedMagazzino = magazzinoRepository.save(magazzino);
            return Optional.of(savedMagazzino);
        }
        return Optional.empty();
    }

    /**
     * Updates an existing Magazzino by its ID if it exists.
     * @param id the ID of the Magazzino to update
     * @param magazzino the Magazzino object with updated information
     * @return an Optional containing the updated Magazzino or empty if not found
     */
    public Optional<Magazzino> update(Long id, Magazzino magazzino){
        Optional<Magazzino> magazzinoOptional = magazzinoRepository.findById(id);
        if (magazzinoOptional.isPresent()){
            Magazzino magazzinoTrovato = magazzinoOptional.get();
            magazzinoTrovato.copyFields(magazzino);

            return Optional.of(magazzinoRepository.save(magazzinoTrovato));
        }
        return Optional.empty();
    }

    /**
     * Deletes a Magazzino by its ID if it exists.
     * @param id the ID of the Magazzino to delete
     * @return true if the Magazzino was deleted, false if not found
     */
    public boolean delete(Long id){
        Optional<Magazzino> magazzinoOptional = magazzinoRepository.findById(id);
        if (magazzinoOptional.isPresent()){
            magazzinoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

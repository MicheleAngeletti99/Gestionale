package com.example.Gestionale.services;

import com.example.Gestionale.entities.Utente;
import com.example.Gestionale.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    // fields
    @Autowired
    private UtenteRepository utenteRepository;

    // crud methods

    /**
     * Creates a new record in utenti table.
     *
     * @param utente the user to be saved, must not be null.
     * @return the saved user, will not be null.
     */
    public Utente create(Utente utente) {
        return utenteRepository.save(utente);
    }

    /**
     * Reads all records in utenti table.
     *
     * @return a List of all users in the table.
     */
    public List<Utente> readAll() {
        return utenteRepository.findAll();
    }

    /**
     * Reads one record in utenti table given its id.
     *
     * @param id the id of the user to find, must not be null.
     * @return an Optional with the found user, an empty Optional if the id is not found.
     */
    public Optional<Utente> readById(Long id){
        return utenteRepository.findById(id);
    }

    /**
     * Updates one record in utenti table given its id and an object containing updated fields.
     *
     * @param id the id of the user to update, must not be null.
     * @param utente the object with the fields to be copied, must not be null.
     * @return an Optional with the updated user, an empty Optional if the id is not found.
     */
    public Optional<Utente> update(Long id, Utente utente) {
        Optional<Utente> optionalUtente = utenteRepository.findById(id);
        if (optionalUtente.isPresent()){
            Utente updateUtente = optionalUtente.get();

            updateUtente.copyFields(utente);

            return Optional.of(utenteRepository.save(updateUtente));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Deletes one record from utenti table given its id.
     *
     * @param id the id of the user to be deleted, must not be null.
     */
    public void deleteById(Long id){
        utenteRepository.deleteById(id);
    }
}

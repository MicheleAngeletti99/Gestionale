package com.example.Gestionale.services;

import com.example.Gestionale.entities.Magazzino;
import com.example.Gestionale.entities.Utente;
import com.example.Gestionale.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MagazzinoService {

    @Autowired
    private MagazzinoRepository magazzinoRepository;

    @Autowired
    private OggAbbigliamentoRepository oggAbbigliamentoRepository;

    @Autowired
    private OggFarmaciaRepository oggFarmaciaRepository;

    @Autowired
    private OggPubRepository oggPubRepository;

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
     * Deletes a Magazzino and its related objects (OggFarmacia, OggPub, OggAbbigliamento) by its ID if it exists.
     * @param id the ID of the Magazzino to delete
     * @return true if the Magazzino and its related objects were deleted, false if not found
     */
    @Transactional
    public boolean delete(Long id){
        Optional<Magazzino> magazzinoOptional = magazzinoRepository.findById(id);
        if (magazzinoOptional.isPresent()){
            oggFarmaciaRepository.deleteOggFarmaciaByMagazzinoId(id);
            oggPubRepository.deleteOggPubByMagazzinoId(id);
            oggAbbigliamentoRepository.deleteOggAbbigliamentoByMagazzinoId(id);

            magazzinoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // search methods

    /**
     * Searches warehouses corresponding to the given fields.
     *
     * @param nomeAttivita a String contained in the name to be searched.
     * @param indirizzo a String contained in the address to be searched.
     * @param tipologiaAttivita the exact type to be searched.
     * @return a List with the found warehouses.
     */
    public List<Magazzino> findByFields(String nomeAttivita, String indirizzo, String tipologiaAttivita) {
        List<Magazzino> magazzini = magazzinoRepository.findByFields(nomeAttivita, indirizzo, tipologiaAttivita);
        return magazzini;
    }
}

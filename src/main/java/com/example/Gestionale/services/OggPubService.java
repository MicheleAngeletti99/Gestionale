package com.example.Gestionale.services;

import com.example.Gestionale.entities.Magazzino;
import com.example.Gestionale.entities.OggPub;
import com.example.Gestionale.repositories.MagazzinoRepository;
import com.example.Gestionale.repositories.OggPubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OggPubService {
    // fields
    @Autowired
    private OggPubRepository oggPubRepository;
    @Autowired
    private MagazzinoRepository magazzinoRepository;

    // crud methods

    /**
     * Creates a new record in ogg_pub table.
     *
     * @param oggetto the item to be saved, must not be null.
     * @param idMagazzino ID of the Magazzino to associate with the OggettoPub.
     * @return the saved item, will not be null.
     */
    public Optional<OggPub> create(OggPub oggetto, Long idMagazzino) {
        Optional<Magazzino> optionalMagazzino = magazzinoRepository.findById(idMagazzino);
        if (optionalMagazzino.isPresent()) {
            Magazzino magazzino = optionalMagazzino.get();
            oggetto.setMagazzino(magazzino);
            OggPub savedOggPub = oggPubRepository.save(oggetto);
            return Optional.of(savedOggPub);
        }
        return Optional.empty();
    }

    /**
     * Reads all records in ogg_pub table.
     *
     * @return a List of all items in the table.
     */
    public List<OggPub> readAll() {
        return oggPubRepository.findAll();
    }

    /**
     * Reads one record in ogg_pub table given its id.
     *
     * @param id the id of the item to find, must not be null.
     * @return an Optional with the found item, an empty Optional if the id is not found.
     */
    public Optional<OggPub> readById(Long id){
        return oggPubRepository.findById(id);
    }

    /**
     * Updates one record in ogg_pub table given its id and an object containing updated fields.
     *
     * @param id the id of the item to update, must not be null.
     * @param oggetto the object with the fields to be copied, must not be null.
     * @return an Optional with the updated item, an empty Optional if the id is not found.
     */
    public Optional<OggPub> update(Long id, OggPub oggetto) {
        Optional<OggPub> optionalOgg = oggPubRepository.findById(id);
        if (optionalOgg.isPresent()){
            OggPub updateOgg = optionalOgg.get();

            updateOgg.copyFieldsPub(oggetto);

            return Optional.of(oggPubRepository.save(updateOgg));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Deletes one record from ogg_pub table given its id.
     *
     * @param id the id of the item to be deleted, must not be null.
     */
    public void deleteById(Long id){
        oggPubRepository.deleteById(id);
    }
}

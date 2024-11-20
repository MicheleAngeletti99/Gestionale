package com.example.Gestionale.services;

import com.example.Gestionale.entities.Magazzino;
import com.example.Gestionale.entities.OggFarmacia;
import com.example.Gestionale.repositories.MagazzinoRepository;
import com.example.Gestionale.repositories.OggFarmaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OggFarmaciaService {
    // fields
    @Autowired
    private OggFarmaciaRepository oggFarmaciaRepository;
    @Autowired
    private MagazzinoRepository magazzinoRepository;

    // crud methods

    /**
     * Creates a new record in ogg_farmacia table.
     *
     * @param oggetto the item to be saved, must not be null.
     * @param idMagazzino ID of the Magazzino to associate with the OggettoFarmacia.
     * @return the saved item, will not be null.
     */
    public Optional<OggFarmacia> create(OggFarmacia oggetto, Long idMagazzino) {
        Optional<Magazzino> optionalMagazzino = magazzinoRepository.findById(idMagazzino);
        if (optionalMagazzino.isPresent()) {
            Magazzino magazzino = optionalMagazzino.get();
            oggetto.setMagazzino(magazzino);
            OggFarmacia savedOggFarmacia = oggFarmaciaRepository.save(oggetto);
            return Optional.of(savedOggFarmacia);
        }
        return Optional.empty();
    }

    /**
     * Reads all records in ogg_farmacia table.
     *
     * @return a List of all items in the table.
     */
    public List<OggFarmacia> readAll() {
        return oggFarmaciaRepository.findAll();
    }

    /**
     * Reads one record in ogg_farmacia table given its id.
     *
     * @param id the id of the item to find, must not be null.
     * @return an Optional with the found item, an empty Optional if the id is not found.
     */
    public Optional<OggFarmacia> readById(Long id){
        return oggFarmaciaRepository.findById(id);
    }

    /**
     * Updates one record in ogg_farmacia table given its id and an object containing updated fields.
     *
     * @param id the id of the item to update, must not be null.
     * @param oggetto the object with the fields to be copied, must not be null.
     * @return an Optional with the updated item, an empty Optional if the id is not found.
     */
    public Optional<OggFarmacia> update(Long id, OggFarmacia oggetto) {
        Optional<OggFarmacia> optionalOgg = oggFarmaciaRepository.findById(id);
        if (optionalOgg.isPresent()){
            OggFarmacia updateOgg = optionalOgg.get();

            updateOgg.copyFieldsFarmacia(oggetto);

            return Optional.of(oggFarmaciaRepository.save(updateOgg));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Deletes one record from ogg_farmacia table given its id.
     *
     * @param id the id of the item to be deleted, must not be null.
     */
    public void deleteById(Long id){
        oggFarmaciaRepository.deleteById(id);
    }

    // other methods

    /**
     * Increases the amount of an item in ogg_farmacia by the given number, decreases if the number is negative.
     *
     * @param id the id of the item to be modified, must not be null.
     * @param amount the increase in amount, decrease if negative.
     * @return an Optional with the updated item, an empty Optional if the id is not found.
     */
    public Optional<OggFarmacia> restock(Long id, Integer amount) {
        Optional<OggFarmacia> optionalOgg = oggFarmaciaRepository.findById(id);
        if (optionalOgg.isPresent()) {
            OggFarmacia updateOgg = optionalOgg.get();

            updateOgg.increase(amount);

            return Optional.of(oggFarmaciaRepository.save(updateOgg));
        } else {
            return Optional.empty();
        }
    }
}

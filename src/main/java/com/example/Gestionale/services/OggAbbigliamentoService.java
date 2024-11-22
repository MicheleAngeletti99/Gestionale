package com.example.Gestionale.services;

import com.example.Gestionale.entities.Magazzino;
import com.example.Gestionale.entities.OggAbbigliamento;
import com.example.Gestionale.repositories.MagazzinoRepository;
import com.example.Gestionale.repositories.OggAbbigliamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OggAbbigliamentoService {
    // fields
    @Autowired
    private OggAbbigliamentoRepository oggAbbigliamentoRepository;
    @Autowired
    private MagazzinoRepository magazzinoRepository;

    // crud methods

    /**
     * Creates a new record in ogg_abbigliamento table.
     *
     * @param oggetto the item to be saved, must not be null.
     * @param idMagazzino ID of the Magazzino to associate with the OggettoAbbigliamento.
     * @return the saved item, will not be null.
     */
    public Optional<OggAbbigliamento> create(OggAbbigliamento oggetto, Long idMagazzino) {
            Optional<Magazzino> optionalMagazzino = magazzinoRepository.findById(idMagazzino);
            if (optionalMagazzino.isPresent()) {
                Magazzino magazzino = optionalMagazzino.get();
                oggetto.setMagazzino(magazzino);
                OggAbbigliamento savedOggAbbigliamento = oggAbbigliamentoRepository.save(oggetto);
                return Optional.of(savedOggAbbigliamento);
            }
            return Optional.empty();
    }

    /**
     * Reads all records in ogg_abbigliamento table.
     *
     * @return a List of all items in the table.
     */
    public List<OggAbbigliamento> readAll() {
        return oggAbbigliamentoRepository.findAll();
    }

    /**
     * Reads one record in ogg_abbigliamento table given its id.
     *
     * @param id the id of the item to find, must not be null.
     * @return an Optional with the found item, an empty Optional if the id is not found.
     */
    public Optional<OggAbbigliamento> readById(Long id){
        return oggAbbigliamentoRepository.findById(id);
    }

    /**
     * Updates one record in ogg_abbigliamento table given its id and an object containing updated fields.
     *
     * @param id the id of the item to update, must not be null.
     * @param oggetto the object with the fields to be copied, must not be null.
     * @return an Optional with the updated item, an empty Optional if the id is not found.
     */
    public Optional<OggAbbigliamento> update(Long id, OggAbbigliamento oggetto) {
        Optional<OggAbbigliamento> optionalOgg = oggAbbigliamentoRepository.findById(id);
        if (optionalOgg.isPresent()){
            OggAbbigliamento updateOgg = optionalOgg.get();

            updateOgg.copyFieldsAbbigliamento(oggetto);

            return Optional.of(oggAbbigliamentoRepository.save(updateOgg));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Deletes one record from ogg_abbigliamento table given its id.
     *
     * @param id the id of the item to be deleted, must not be null.
     */
    public void deleteById(Long id){
        oggAbbigliamentoRepository.deleteById(id);
    }

    // other methods

    /**
     * Increases the amount of an item in ogg_abbigliamento table by the given number, decreases if the number is negative.
     *
     * @param id the id of the item to be modified, must not be null.
     * @param amount the increase in amount, decrease if negative.
     * @return an Optional with the updated item, an empty Optional if the id is not found.
     */
    public Optional<OggAbbigliamento> restock(Long id, Integer amount) {
        Optional<OggAbbigliamento> optionalOgg = oggAbbigliamentoRepository.findById(id);
        if (optionalOgg.isPresent()) {
            OggAbbigliamento updateOgg = optionalOgg.get();

            updateOgg.increase(amount);

            return Optional.of(oggAbbigliamentoRepository.save(updateOgg));
        } else {
            return Optional.empty();
        }
    }

    // search methods

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
    public  List<OggAbbigliamento> findByFields(String nome, Double prezzo, Integer quantita, String descrizione,
                                                String marca, String taglia, String tipologia){
        List<OggAbbigliamento> items = oggAbbigliamentoRepository.findByFields(nome, prezzo, quantita, descrizione, marca, taglia, tipologia);
        return items;
    }
}

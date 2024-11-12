package com.example.Gestionale.services;

import com.example.Gestionale.entities.Magazzino;
import com.example.Gestionale.entities.OggAbbigliamento;
import com.example.Gestionale.entities.Utente;
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
}

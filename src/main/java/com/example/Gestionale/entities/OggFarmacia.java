package com.example.Gestionale.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "ogg_farmacia")
public class OggFarmacia extends Oggetto{
    // information fields
    private Boolean conRicetta;
    private LocalDate scadenza;
    private String codiceIdentificativo;
    // relation fields
    @ManyToOne
    @JoinColumn(name = "id_magazzino")
    @JsonIgnore
    private Magazzino magazzino;

    // no args constructor
    public OggFarmacia() {
    }
    // all args constructor
    public OggFarmacia(Long id, String nome, Double prezzo, Integer quantita, String descrizione,
                       Boolean conRicetta, LocalDate scadenza, String codiceIdentificativo, Magazzino magazzino) {
        super(id, nome, prezzo, quantita, descrizione);
        this.conRicetta = conRicetta;
        this.scadenza = scadenza;
        this.codiceIdentificativo = codiceIdentificativo;
        this.magazzino = magazzino;
    }

    // getters & setters

    public Boolean isConRicetta() {
        return conRicetta;
    }

    public void setConRicetta(Boolean conRicetta) {
        this.conRicetta = conRicetta;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public String getCodiceIdentificativo() {
        return codiceIdentificativo;
    }

    public void setCodiceIdentificativo(String codiceIdentificativo) {
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

    /**
     * This method copies the information fields of another object of the same class, it copies only the fields that are not null.
     *
     * @param oggetto the object that contains the fields to be copied.
     */
    public void copyFieldsFarmacia(OggFarmacia oggetto) {
        super.copyFields(oggetto);
        if (oggetto.isConRicetta() != null) this.conRicetta = oggetto.isConRicetta();
        if (oggetto.getScadenza() != null) this.scadenza = oggetto.getScadenza();
        if (oggetto.getCodiceIdentificativo() != null) this.codiceIdentificativo = oggetto.getCodiceIdentificativo();
    }
}

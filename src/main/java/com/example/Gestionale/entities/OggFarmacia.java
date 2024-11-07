package com.example.Gestionale.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "ogg_farmacia")
public class OggFarmacia extends Oggetto{
    // fields
    private boolean conRicetta;
    private LocalDate scadenza;
    private String codiceIdentificativo;

    // no args constructor
    public OggFarmacia() {
    }
    // all args constructor
    public OggFarmacia(Long id, String nome, boolean conRicetta, LocalDate scadenza, String codiceIdentificativo) {
        super(id, nome);
        this.conRicetta = conRicetta;
        this.scadenza = scadenza;
        this.codiceIdentificativo = codiceIdentificativo;
    }

    // getters & setters

    public boolean isConRicetta() {
        return conRicetta;
    }

    public void setConRicetta(boolean conRicetta) {
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

    /**
     * This method copies the fields of another object of the same class, except id.
     *
     * @param oggetto the object that contains the fields to be copied.
     */
    public void copyFieldsFarmacia(OggFarmacia oggetto) {
        super.copyFields(oggetto);
        this.conRicetta = oggetto.isConRicetta();
        this.scadenza = oggetto.getScadenza();
        this.codiceIdentificativo = oggetto.getCodiceIdentificativo();
    }
}

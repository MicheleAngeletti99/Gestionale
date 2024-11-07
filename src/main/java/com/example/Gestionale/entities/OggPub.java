package com.example.Gestionale.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "ogg_pub")
public class OggPub extends Oggetto{
    // fields
    private LocalDate scadenza;
    private String tipologia;

    // no args constructor
    public OggPub() {
    }
    // all args constructor
    public OggPub(Long id, String nome, LocalDate scadenza, String tipologia) {
        super(id, nome);
        this.scadenza = scadenza;
        this.tipologia = tipologia;
    }

    // getters & setters

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    /**
     * This method copies the fields of another object of the same class, except id.
     *
     * @param oggetto the object that contains the fields to be copied.
     */
    public void copyFieldsPub(OggPub oggetto) {
        super.copyFields(oggetto);
        this.scadenza = oggetto.getScadenza();
        this.tipologia = oggetto.getTipologia();
    }
}

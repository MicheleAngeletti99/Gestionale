package com.example.Gestionale.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "ogg_pub")
public class OggPub extends Oggetto{
    // information fields
    private LocalDate scadenza;
    private String tipologia;
    // relation fields
    @ManyToOne
    @JoinColumn(name = "id_magazzino")
    @JsonIgnore
    private Magazzino magazzino;

    // no args constructor
    public OggPub() {
    }
    // all args constructor
    public OggPub(Long id, String nome, Double prezzo, Integer quantita, String descrizione, LocalDate scadenza,
                  String tipologia, Magazzino magazzino) {
        super(id, nome, prezzo, quantita, descrizione);
        this.scadenza = scadenza;
        this.tipologia = tipologia;
        this.magazzino = magazzino;
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
    public void copyFieldsPub(OggPub oggetto) {
        super.copyFields(oggetto);
        if (oggetto.getScadenza() != null) this.scadenza = oggetto.getScadenza();
        if (oggetto.getTipologia() != null) this.tipologia = oggetto.getTipologia();
    }
}

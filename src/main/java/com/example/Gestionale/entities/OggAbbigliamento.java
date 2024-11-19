package com.example.Gestionale.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ogg_abbigliamento")
public class OggAbbigliamento extends Oggetto{
    // information fields
    private String marca;
    private String taglia;
    private String tipologia;
    // relation fields
    @ManyToOne
    @JoinColumn(name = "id_magazzino")
    @JsonIgnore
    private Magazzino magazzino;

    // no args constructor
    public OggAbbigliamento() {
    }
    // all args constructor
    public OggAbbigliamento(Long id, String nome, Double prezzo, Integer quantita, String descrizione,
                            String marca, String taglia, String tipologia, Magazzino magazzino) {
        super(id, nome, prezzo, quantita, descrizione);
        this.marca = marca;
        this.taglia = taglia;
        this.tipologia = tipologia;
        this.magazzino = magazzino;
    }

    // getters & setters

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTaglia() {
        return taglia;
    }

    public void setTaglia(String taglia) {
        this.taglia = taglia;
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
    public void copyFieldsAbbigliamento(OggAbbigliamento oggetto) {
        super.copyFields(oggetto);
        if (oggetto.getMarca() != null) this.marca = oggetto.getMarca();
        if (oggetto.getTaglia() != null) this.taglia = oggetto.getTaglia();
        if (oggetto.getTipologia() != null) this.tipologia = oggetto.getTipologia();
    }
}

package com.example.Gestionale.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ogg_abbigliamento")
public class OggAbbigliamento extends Oggetto{
    // fields
    private String marca;
    private String taglia;
    private String tipologia;

    // no args constructor
    public OggAbbigliamento() {
    }
    // all args constructor
    public OggAbbigliamento(Long id, String nome, String marca, String taglia, String tipologia) {
        super(id, nome);
        this.marca = marca;
        this.taglia = taglia;
        this.tipologia = tipologia;
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

    /**
     * This method copies the fields of another object of the same class, except id.
     *
     * @param oggetto the object that contains the fields to be copied.
     */
    public void copyFieldsAbbigliamento(OggAbbigliamento oggetto) {
        super.copyFields(oggetto);
        this.marca = oggetto.getMarca();
        this.taglia = oggetto.getTaglia();
        this.tipologia = oggetto.getTipologia();
    }
}

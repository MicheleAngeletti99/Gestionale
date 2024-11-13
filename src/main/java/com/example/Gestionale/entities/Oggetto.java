package com.example.Gestionale.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class Oggetto {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // shared information fields
    private String nome;
    private Double prezzo;
    private Integer quantita;
    private String descrizione;

    // no args constructor
    public Oggetto() {
    }
    // all args constructor
    public Oggetto(Long id, String nome, Double prezzo, Integer quantita, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.descrizione = descrizione;
    }

    // getters & setters

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * This method copies the information fields of another object of the same class.
     *
     * @param oggetto the object that contains the fields to be copied.
     */
    public void copyFields(Oggetto oggetto) {
        this.nome = oggetto.getNome();
        this.prezzo = oggetto.getPrezzo();
        this.quantita = oggetto.getQuantita();
        this.descrizione = oggetto.getDescrizione();
    }
}
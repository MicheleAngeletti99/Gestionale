package com.example.Gestionale.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class Oggetto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "magazzino")
    private Magazzino magazzino;

    private Double prezzo;
    private Integer quantita;
    private String descrizione;

    public Oggetto() {
    }

    public Oggetto(Long id, String nome, Magazzino magazzino , Double prezzo, Integer quantita, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.magazzino = magazzino;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.descrizione = descrizione;
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(Magazzino magazzino) {
        this.magazzino = magazzino;
    }

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

    // Copy the fields of another object given as an argument.
    public void copyFields(Oggetto oggetto) {
        this.nome = oggetto.getNome();
    }
}

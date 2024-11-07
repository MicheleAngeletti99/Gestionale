package com.example.Gestionale.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "oggetti")
public class Oggetto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Oggetto() {
    }

    public Oggetto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    // copia i campi di un altro oggetto dato in argomento
    public void copyFields(Oggetto oggetto) {
        this.nome = oggetto.getNome();
    }
}

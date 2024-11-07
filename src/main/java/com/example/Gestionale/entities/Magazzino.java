package com.example.Gestionale.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "magazzino")
public class Magazzino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "magazzino")
    private List<Oggetto> oggetto;

    private String nomeAttivita;
    private String email;
    private String password;
    private String indirizzo;
    private String tipologiaAttivita;

    public Magazzino() {
    }

    public Magazzino(Long id, String nomeAttivita, String email, String password, String indirizzo, String tipologia, List<Oggetto> oggetto) {
        this.id = id;
        this.nomeAttivita = nomeAttivita;
        this.email = email;
        this.password = password;
        this.indirizzo = indirizzo;
        this.tipologiaAttivita = tipologia;
        this.oggetto = oggetto;
    }

    public Long getId() {
        return id;
    }

    public List<Oggetto> getOggetto() {
        return oggetto;
    }

    public void setOggetto(List<Oggetto> oggetto) {
        this.oggetto = oggetto;
    }

    public String getNomeAttivita() {
        return nomeAttivita;
    }

    public void setNomeAttivita(String nomeAttivita) {
        this.nomeAttivita = nomeAttivita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTipologia() {
        return tipologiaAttivita;
    }

    public void setTipologia(String tipologia) {
        this.tipologiaAttivita = tipologia;
    }
}

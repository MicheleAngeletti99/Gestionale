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
    private List<OggAbbigliamento> oggettiAbbigliamento;
    @OneToMany(mappedBy = "magazzino")
    private List<OggFarmacia> oggettiFarmacia;
    @OneToMany(mappedBy = "magazzino")
    private List<OggPub> oggettiPub;

    private String nomeAttivita;
    private String email;
    private String password;
    private String indirizzo;
    private String tipologiaAttivita;

    public Magazzino() {
    }

    public Magazzino(Long id, String nomeAttivita, String email, String password, String indirizzo, String tipologia,
                     List<OggAbbigliamento> oggettiAbbigliamento, List<OggFarmacia> oggettiFarmacia, List<OggPub> oggettiPub) {
        this.id = id;
        this.nomeAttivita = nomeAttivita;
        this.email = email;
        this.password = password;
        this.indirizzo = indirizzo;
        this.tipologiaAttivita = tipologia;
        this.oggettiAbbigliamento = oggettiAbbigliamento;
        this.oggettiFarmacia = oggettiFarmacia;
        this.oggettiPub = oggettiPub;
    }

    public Long getId() {
        return id;
    }

    public List<OggAbbigliamento> getOggettiAbbigliamento() {
        return oggettiAbbigliamento;
    }

    public void setOggettiAbbigliamento(List<OggAbbigliamento> oggettiAbbigliamento) {
        this.oggettiAbbigliamento = oggettiAbbigliamento;
    }

    public List<OggFarmacia> getOggettiFarmacia() {
        return oggettiFarmacia;
    }

    public void setOggettiFarmacia(List<OggFarmacia> oggettiFarmacia) {
        this.oggettiFarmacia = oggettiFarmacia;
    }

    public List<OggPub> getOggettiPub() {
        return oggettiPub;
    }

    public void setOggettiPub(List<OggPub> oggettiPub) {
        this.oggettiPub = oggettiPub;
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

    public String getTipologiaAttivita() {
        return tipologiaAttivita;
    }

    public void setTipologiaAttivita(String tipologia) {
        this.tipologiaAttivita = tipologia;
    }

    // Copy the fields of another object given as an argument.
    public void copyFields(Magazzino magazzino) {
        this.nomeAttivita = magazzino.getNomeAttivita();
        this.email = magazzino.getEmail();
        this.password = magazzino.getPassword();
        this.indirizzo = magazzino.getIndirizzo();
        this.tipologiaAttivita = magazzino.getTipologiaAttivita();
    }
}

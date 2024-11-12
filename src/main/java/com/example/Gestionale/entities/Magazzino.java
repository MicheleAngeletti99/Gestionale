package com.example.Gestionale.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "magazzini")
public class Magazzino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // fields
    private String nomeAttivita;
    private String indirizzo;
    private String tipologiaAttivita;
    // relations
    @OneToMany(mappedBy = "magazzino")
    private List<OggAbbigliamento> oggettiAbbigliamento;
    @OneToMany(mappedBy = "magazzino")
    private List<OggFarmacia> oggettiFarmacia;
    @OneToMany(mappedBy = "magazzino")
    private List<OggPub> oggettiPub;
    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    public Magazzino() {
    }

    public Magazzino(Long id, String nomeAttivita, String indirizzo, String tipologia,
                     List<OggAbbigliamento> oggettiAbbigliamento, List<OggFarmacia> oggettiFarmacia, List<OggPub> oggettiPub, Utente utente) {
        this.id = id;
        this.nomeAttivita = nomeAttivita;
        this.indirizzo = indirizzo;
        this.tipologiaAttivita = tipologia;
        this.oggettiAbbigliamento = oggettiAbbigliamento;
        this.oggettiFarmacia = oggettiFarmacia;
        this.oggettiPub = oggettiPub;
        this.utente = utente;
    }

    public Long getId() {
        return id;
    }

    public String getNomeAttivita() {
        return nomeAttivita;
    }

    public void setNomeAttivita(String nomeAttivita) {
        this.nomeAttivita = nomeAttivita;
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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    // Copy the fields of another object given as an argument.
    public void copyFields(Magazzino magazzino) {
        this.nomeAttivita = magazzino.getNomeAttivita();
        this.indirizzo = magazzino.getIndirizzo();
        this.tipologiaAttivita = magazzino.getTipologiaAttivita();
    }
}

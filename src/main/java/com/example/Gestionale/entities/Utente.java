package com.example.Gestionale.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // information fields
    private String email;
    private String password;
    // relation fields
    @OneToMany(mappedBy = "utente")
    private List<Magazzino> magazzini;

    // no args constructor
    public Utente() {
    }
    // all args constructor
    public Utente(Long id, String email, String password, List<Magazzino> magazzini) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.magazzini = magazzini;
    }

    // getters & setters

    public Long getId() {
        return id;
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

    public List<Magazzino> getMagazzini() {
        return magazzini;
    }

    public void setMagazzini(List<Magazzino> magazzini) {
        this.magazzini = magazzini;
    }

    /**
     * This method copies the information fields of another object of the same class, it copies only the fields that are not null.
     *
     * @param utente the object that contains the fields to be copied.
     */
    public void copyFields(Utente utente) {
        if (utente.getEmail() != null) this.email = utente.getEmail();
        if (utente.getPassword() != null) this.password = utente.getPassword();
    }
}

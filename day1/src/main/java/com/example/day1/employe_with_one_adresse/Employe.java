package com.example.day1.employe_with_one_adresse;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employe {
    
    @Id
    private String id;
    private String nom;
    private String prenom;

    @Embedded
    private Adresse adresse;

    @ElementCollection
    private List<String> telephones;

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Employe() {
        this.id = UUID.randomUUID().toString();
    }

    public String getPrenom() {
        return prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public List<String> getTelephones() {
        return telephones;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }
    
}

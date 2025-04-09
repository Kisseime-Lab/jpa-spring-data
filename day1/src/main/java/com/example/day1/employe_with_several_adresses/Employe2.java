package com.example.day1.employe_with_several_adresses;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employe2")
public class Employe2 {
    @Id
    private String id;
    private String nom;
    private String prenom;

    @ManyToMany(mappedBy = "employes", cascade = CascadeType.ALL)
    private List<Adresse2> adresse;

    @ElementCollection
    private List<String> telephones;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<String> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public Employe2() {
        this.id = UUID.randomUUID().toString();
    }

    public List<Adresse2> getAdresse() {
        return adresse;
    }

    public void setAdresse(List<Adresse2> adresse) {
        this.adresse = adresse;
    }

}

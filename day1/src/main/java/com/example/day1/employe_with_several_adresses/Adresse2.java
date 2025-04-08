package com.example.day1.employe_with_several_adresses;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Adresse2")
public class Adresse2 {
    @Id
    private String id;
    private String libelle;
    private String zip;
    private String ville;

    @ManyToMany
    @JoinTable(name = "Employe_Adresse", joinColumns = @JoinColumn(nullable = false, name = "adresse_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(nullable = false, name = "employe_id", referencedColumnName = "id"))
    private List<Employe2> employes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Adresse2() {
        this.id = UUID.randomUUID().toString();
    }

}

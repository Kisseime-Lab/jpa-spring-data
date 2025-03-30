package com.example.employe_with_one_adresse;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
    private String libelle;
    private String zip;
    private String ville;
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
    
}

package com.example.day1.employe_with_one_adresse;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Contrat {
    
    public Contrat() {
        this.id = UUID.randomUUID().toString();
    }
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @OneToOne(optional= false)
    @JoinColumn(name= "employe_id", referencedColumnName= "id", insertable=false, updatable = false)
    private Employe employe;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
}

package com.example.dayx.transaction_not_supported;

import java.util.NoSuchElementException;

import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.day1.employe_with_one_adresse.Employe;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    private final EmployeService service;

    public EmployeController(EmployeService service) {
        this.service = service;
    }

    @GetMapping
    @Transactional
    public String updateEmploye() {
        Employe employe = new Employe();
        try {

            service.createEmploye(employe);
            service.updateCache(employe);
            System.out.println("getUser : " + service.getEmploye(employe.getId())
                    .orElseThrow(() -> new NoSuchElementException("Employe non trouvé")).getId());
            employe.setNom("Kisseime");
            service.updateEmployeProfile(employe);
            service.updateCache(employe);
            return "Employe updated succesfully";
        } catch (UnexpectedRollbackException e) {
            String nom = service.getEmploye(employe.getId())
                    .orElseThrow(() -> new NoSuchElementException("Employe non trouvé")).getNom();
            System.out.println(nom);
            return "updated cache successfully, new name: " + nom;
        }
    }
}

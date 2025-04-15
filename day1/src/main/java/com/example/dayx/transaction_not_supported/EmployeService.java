package com.example.dayx.transaction_not_supported;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.day1.employe_with_one_adresse.Employe;
import com.example.day1.employe_with_one_adresse.EmployeRepository;

@Service
public class EmployeService {
    private Map<String, Employe> cache = new HashMap<>();
    private final EmployeRepository repository;

    public EmployeService(EmployeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Employe updateEmployeProfile(Employe employe) {
        throw new RuntimeException("Boom!");
        // Employe exisEmploye = repository.findById(employe.getId())
        // .orElseThrow(() -> new NoSuchElementException("Employe non trouvé"));
        // employe.setId(exisEmploye.getId());
        // return repository.save(employe);
    }

    @Transactional
    public Employe createEmploye(Employe employe) {
        return repository.save(employe);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void updateCache(Employe employe) {
        System.out.println("Updating the cache !");
        this.cache.put(employe.getId(), employe);
    }

    @Transactional(readOnly = true)
    public Optional<Employe> getEmploye(String id) {
        if (this.cache.get(id) != null) {
            System.out.println("get from the cache");
            return Optional.of(this.cache.get(id));
        }
        System.out.println("get from DB");
        return repository.findById(id);
    }
}

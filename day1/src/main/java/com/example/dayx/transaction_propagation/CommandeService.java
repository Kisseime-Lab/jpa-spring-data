package com.example.dayx.transaction_propagation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommandeService {

    private final CommandRepository repository;

    public CommandeService(CommandRepository repository) {
        this.repository = repository;
    }

    public Commande validateCommande(Long id) {
        Commande commande = repository.findById(id).orElse(null);
        commande.setValidated(true);
        return repository.save(commande);
    }

    @Transactional
    public Commande saveCommande(Commande commande) {
        return repository.save(commande);
    }
}

package com.example.dayx.transaction_propagation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceService {

    private final InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Invoice createInvoice(Commande commande) {
        Invoice invoice = new Invoice();
        commande.setFacture(invoice);
        invoice.setCommande(commande);
        return repository.save(invoice);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Invoice getInvoice(Long id) {
        return repository.findById(id).orElse(null);
    }
}

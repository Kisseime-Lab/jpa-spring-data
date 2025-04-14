package com.example.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dayx.transaction_propagation.Commande;
import com.example.dayx.transaction_propagation.CommandeService;
import com.example.dayx.transaction_propagation.EmailService;
import com.example.dayx.transaction_propagation.Invoice;
import com.example.dayx.transaction_propagation.InvoiceService;

@SpringBootTest
public class DayxTests {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private CommandeService commandeService;

    @Test
    public void sample() {
        Commande commande = commandeService.saveCommande(new Commande());
        commande = commandeService.validateCommande(commande.getId());
        Invoice invoice = invoiceService.createInvoice(commande);
        commande.setFacture(invoice);
        commandeService.saveCommande(commande);
        assertThrows(RuntimeException.class, () -> emailService.sendEmail());
        assertEquals(1L, invoiceService.getInvoice(1L).getCommande().getId());
    }
}

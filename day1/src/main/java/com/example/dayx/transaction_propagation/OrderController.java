package com.example.dayx.transaction_propagation;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final CommandeService orderService;
    private final EmailService emailService;
    private final InvoiceService invoiceService;

    public OrderController(CommandeService orderService, EmailService emailService, InvoiceService invoiceService) {
        this.orderService = orderService;
        this.emailService = emailService;
        this.invoiceService = invoiceService;
    }

    @GetMapping
    @Transactional
    public String placeOrder() {
        try {
            Commande commande = orderService.saveCommande(new Commande());
            invoiceService.createInvoice(commande);
            emailService.sendEmail();
            return "Order processed";
        } catch (Exception e) {
            // TODO: handle exception
            // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "Error sending email";
        }
    }
}

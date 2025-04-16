package com.example.dayx.read_committed;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private BankingServiceA bankingServiceA;

    @Autowired
    private BankingServiceB bankingServiceB;

    @GetMapping("/isolation")
    public void testIsolation() {
        Long accountId = 1L;

        bankingServiceA.createAccount();
        new Thread(() -> bankingServiceB.debitAccount(accountId, new BigDecimal("50.00"))).start();

        try {
            Thread.sleep(1000); // Laisse B démarrer avant A
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        bankingServiceA.checkBalance(accountId);
    }

}

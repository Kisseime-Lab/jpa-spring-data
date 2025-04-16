package com.example.dayx.read_committed;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankingServiceA {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void checkBalance(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        System.out.println("Read Balance: " + account.getBalance());

        try {
            Thread.sleep(5000); // Simule un traitement long
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Account refreshed = accountRepository.findById(accountId).orElseThrow();
        System.out.println("Re-read Balance: " + refreshed.getBalance());
    }

    @Transactional
    public void createAccount() {
        Account account = new Account();
        account.setId(1L);
        account.setBalance(BigDecimal.valueOf(0));
        accountRepository.save(account);
        System.out.println("account created!");
    }
}

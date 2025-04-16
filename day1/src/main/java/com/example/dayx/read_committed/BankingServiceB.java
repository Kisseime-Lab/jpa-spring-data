package com.example.dayx.read_committed;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankingServiceB {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void debitAccount(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance().subtract(amount));
        System.out.println("Balance updated but not yet committed: " + account.getBalance());

        try {
            Thread.sleep(8000); // Retarde le commit
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

package com.example.dayx.read_committed;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    private Long id;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    // getters, setters
}

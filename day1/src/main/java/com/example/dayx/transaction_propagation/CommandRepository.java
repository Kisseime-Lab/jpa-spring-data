package com.example.dayx.transaction_propagation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Commande, Long> {

}

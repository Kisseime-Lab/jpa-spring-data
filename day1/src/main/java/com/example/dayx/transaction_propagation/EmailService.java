package com.example.dayx.transaction_propagation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {

    @Transactional(propagation = Propagation.REQUIRED)
    public void sendEmail() {
        throw new RuntimeException("Fail sending email");
        // System.out.println("Email sent !");
    }
}

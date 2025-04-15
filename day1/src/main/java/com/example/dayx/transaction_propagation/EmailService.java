package com.example.dayx.transaction_propagation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendEmail() {
        System.out.println("Sending email to ");
        throw new RuntimeException("Failed to send email");

    }
}

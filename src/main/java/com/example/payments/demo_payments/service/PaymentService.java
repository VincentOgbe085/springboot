package com.example.payments.demo_payments.service;

import com.example.payments.demo_payments.exceptions.NoMatchingPaymentException;
import com.example.payments.demo_payments.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAll();

    Payment getById(Long id) throws NoMatchingPaymentException;

    List<Payment> getAllByCountry(String country);

    Payment save(Payment payment);
}

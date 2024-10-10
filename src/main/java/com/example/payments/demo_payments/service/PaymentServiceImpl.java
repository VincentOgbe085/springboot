package com.example.payments.demo_payments.service;

import com.example.payments.demo_payments.data.PaymentRepository;
import com.example.payments.demo_payments.exceptions.NoMatchingPaymentException;
import com.example.payments.demo_payments.model.Payment;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;

    private Logger logger  = LoggerFactory.getLogger(PaymentServiceImpl.class);

    public  PaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAll(){
        logger.info("get all payments has been called");
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(Long id) throws NoMatchingPaymentException {
        return paymentRepository.findById(id).orElseThrow(()-> new NoMatchingPaymentException("No payment exists with id " + id));
    }

    @Override
    public List<Payment> getAllByCountry(String country) {
        return paymentRepository.findAllByCountry(country);
    }

    @Override
    @Transactional
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }


    ;





}

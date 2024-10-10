package com.example.payments.demo_payments.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoMatchingPaymentException extends Exception{

    public  NoMatchingPaymentException(String message){
        super(message);
    }
}

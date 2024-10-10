package com.example.payments.demo_payments.control;

import com.example.payments.demo_payments.DemoPaymentsApplication;
import com.example.payments.demo_payments.data.PaymentRepository;
import com.example.payments.demo_payments.model.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public class HealthCheckController {

    @GetMapping("/health")
    public Map<String, String> healthcheck(){
        return Map.of("status","ok");
    }

//    @GetMapping("/test")
//    public ResponseEntity<Payment> test() {
//        return ResponseEntity.created("/payment/").body(null);
//    }

}

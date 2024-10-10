package com.example.payments.demo_payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DemoPaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPaymentsApplication.class, args);
	}

}

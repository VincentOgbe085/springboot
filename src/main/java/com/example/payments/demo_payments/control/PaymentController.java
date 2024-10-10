package com.example.payments.demo_payments.control;

import com.example.payments.demo_payments.service.PaymentService;
import com.example.payments.demo_payments.exceptions.NoMatchingPaymentException;
import com.example.payments.demo_payments.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public Payment addNewPayment(@RequestBody Payment payment){
        return paymentService.save(payment);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Object getPayment(@RequestParam(value = "country", required = false) String country){
        if(country != null){
            return paymentService.getAllByCountry(country);
        } else if (false) {
            return  new Payment();

        } else {
            return paymentService.getAll();
        }

    }

    @GetMapping("/{id}")
    public  Payment getPaymentByID(@PathVariable("id") Long id) throws NoMatchingPaymentException {
        return  paymentService.getById(id);
    }

    @PatchMapping("/{id}")
    public Payment patch(@RequestBody Map<String,Object> data){

        if (data.containsKey("country")){

        }
        return null;

    }
}

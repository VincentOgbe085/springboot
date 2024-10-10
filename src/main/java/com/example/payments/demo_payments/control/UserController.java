package com.example.payments.demo_payments.control;

import com.example.payments.demo_payments.model.User;
import com.example.payments.demo_payments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/User")
    public List<User> getAll(){
        return  userService.getAll();
    }
}

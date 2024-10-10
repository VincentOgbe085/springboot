package com.example.payments.demo_payments.service;

import com.example.payments.demo_payments.dtos.UserDTO;
import com.example.payments.demo_payments.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    List<User> getAll();

    User save(User user);
}

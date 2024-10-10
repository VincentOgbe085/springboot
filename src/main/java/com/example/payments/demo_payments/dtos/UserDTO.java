package com.example.payments.demo_payments.dtos;

import com.example.payments.demo_payments.model.User;
import com.example.payments.demo_payments.model.UserRole;

import java.util.Objects;

public class UserDTO {

    private Long id;
    private String name;
    private UserRole role;

    public UserDTO (User user){
        this.id = user.getId();
        this.name = user.getName();
        this.role = user.getRole();
    }

    public User asUser(){
        User user = new User();
        user.setId(id);
        user.setRole(role);
        user.setName(name);
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(name, userDTO.name) && role == userDTO.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}

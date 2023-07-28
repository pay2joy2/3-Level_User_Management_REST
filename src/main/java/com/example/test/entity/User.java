package com.example.test.entity;

import com.example.test.core.dto.enums.Roles;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    private int id;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name ="role")
    private Roles role;

    public User(){}

    public User(String lastname, String name, String email, Roles role) {
        this.lastname = lastname;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "user{" +
                "primaryKeys=" + id +
                ", lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}

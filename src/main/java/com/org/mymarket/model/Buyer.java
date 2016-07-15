package com.org.mymarket.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by denis on 02.07.16.
 */
@Entity
@Table(name = "buyers")
public class Buyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    @NotEmpty(message = "Please enter your name and surname")
    String name;
    @Column(name = "city")
    @NotEmpty(message = "Please enter city where you live")
    String city;
    @Column(name = "phoneNumber")
    @NotEmpty(message = "Please enter your phone number")
    String phoneNumber;
    @Column(name = "email")
    @NotEmpty(message = "Please enter your email")
    @Email(message = "Example: myemail@com.ua")
    String email;


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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

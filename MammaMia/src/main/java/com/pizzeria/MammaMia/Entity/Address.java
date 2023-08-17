package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter
    private String streetName;
    @Getter @Setter
    private int streetNum;
    @Getter @Setter
    private String addressReference;
    @Getter @Setter
    private String city;
    @Getter @Setter
    private String state;
    @Getter @Setter
    private String postalCode;
    public Address(){
    }
    public Address(Long id, String streetName, int streetNum, String addressReference, String city, String state, String postalCode) {
        this.id = id;
        this.streetName = streetName;
        this.streetNum = streetNum;
        this.addressReference = addressReference;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }
}

package br.edu.infnet.apphospitalar.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Address {

    public Address() {

    }
    public Address(Long id) {
        this.id = id;
    }
    public Address(String street,String state,String city,String postalCode,String number) {
        this.street= street;
        this.state= state;
        this.city= city;
        this.postalCode= postalCode;
        this.number= number;
    }

    @Getter
    @Setter
    private String street;

    @Getter
    @Setter
    private String state;

    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private String postalCode;

    @Getter
    @Setter
    private String number;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Override
    public String toString() {
        return "Address:" +
                "street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", number='" + number + '\'' +
                ", id='" + id;
    }
}

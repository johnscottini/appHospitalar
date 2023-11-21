package br.edu.infnet.apphospitalar.model.domain;

import lombok.Getter;
import lombok.Setter;

public class Address {

    public Address() {

    }

    public Address(String street,String state,String city,String postalCode,String number, String id) {
        this.street= street;
        this.state= state;
        this.city= city;
        this.postalCode= postalCode;
        this.number= number;
        this.id = id;
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

    @Getter
    @Setter
    private String id;

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

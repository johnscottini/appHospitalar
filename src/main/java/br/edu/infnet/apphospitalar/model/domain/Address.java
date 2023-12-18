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
    public Address(String street, String state, String neighborhood, String postalCode, String locale) {
        this.street= street;
        this.state= state;
        this.neighborhood = neighborhood;
        this.postalCode= postalCode;
        this.locale = locale;
    }

    @Getter
    @Setter
    private String street;

    @Getter
    @Setter
    private String state;

    @Getter
    @Setter
    private String neighborhood;

    @Getter
    @Setter
    private String postalCode;

    @Getter
    @Setter
    private String locale;

    @Getter
    @Setter
    private String complement;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    public Address(String postalCode) {
        this();
        this.postalCode= postalCode;
    }


    @Override
    public String toString() {
        return "Address:" +
                "street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", locale='" + locale + '\'' +
                ", complement='" + complement + '\'' +
                ", id='" + id;
    }
}

package br.edu.infnet.apphospitalar.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public abstract class Person {

    public Person (String fullName,LocalDate birthDate, String cpf, Address address) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.address = address;
    }

    @Getter
    @Setter
    private String fullName;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String cpf;

    @Getter
    @Setter
    private LocalDate birthDate;

    @Getter
    @Setter
    private Address address;

    public Person() {
    }

    @Override
    public String toString() {
        return  "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthDate=" + birthDate +
                ", address=" + address +
                '}';
    }
}

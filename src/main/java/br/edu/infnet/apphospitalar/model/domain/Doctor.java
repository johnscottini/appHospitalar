package br.edu.infnet.apphospitalar.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person{

    public Doctor(String fullName, LocalDate birthDate, String cpf, Address address, String crm, String specialty) {
        super(fullName, birthDate, cpf, address);
        this.crm= crm;
        this.specialty = specialty;
        this.consultationList = new ArrayList<>();
    }

    @Getter
    @Setter
    private String crm;

    @Getter
    @Setter
    List<Consultation> consultationList;

    @Getter
    @Setter
    private String specialty;

    public Doctor() {

    }
}

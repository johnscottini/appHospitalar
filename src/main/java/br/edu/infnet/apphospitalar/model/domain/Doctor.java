package br.edu.infnet.apphospitalar.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    public Doctor(String fullName, LocalDate birthDate, String cpf, Address address, String crm, String specialty) {
        super(fullName, birthDate, cpf, address);
        this.crm= crm;
        this.specialty = specialty;
    }

    @OneToMany(mappedBy = "doctor",orphanRemoval = true, cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Consultation> consultationList = new ArrayList<>();

    @Getter
    @Setter
    private String crm;

    @Getter
    @Setter
    private String specialty;

    public Doctor() {

    }

    public Doctor(Long id) {
        this.id=id;
    }
}

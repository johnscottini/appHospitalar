package br.edu.infnet.apphospitalar.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    public Patient() {

    }

    public Patient(Long id) {
        this.id = id;
    }
    public Patient(String fullName, LocalDate birthDate, LocalDateTime arrivalTime, String cpf, int score, Address address, MedicalQuestionnaire questionnaire) {
        super(fullName, birthDate, cpf, address);
        this.arrivalTime = arrivalTime;
        this.questionnaire = questionnaire;
    }

    @Getter
    @Setter
    private LocalDateTime arrivalTime;

    @OneToOne(cascade = CascadeType.MERGE)
    @Getter
    @Setter
    private MedicalQuestionnaire questionnaire;

    @Getter
    @Setter
    private int score;

    @Override
    public String toString() {
        return super.toString() +
                "arrivalTime=" + arrivalTime +
                ", questionnaire=" + questionnaire;
    }

}

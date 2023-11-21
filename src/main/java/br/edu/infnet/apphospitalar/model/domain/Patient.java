package br.edu.infnet.apphospitalar.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person{

    public Patient() {

    }
    public Patient(String fullName, LocalDate birthDate, LocalDateTime arrivalTime, String cpf, int score, Address address, MedicalQuestionnaire questionnaire) {
        super(fullName, birthDate, cpf, address);
        this.arrivalTime = arrivalTime;
        this.questionnaire = questionnaire;
        this.score= score;
        this.consultationList = new ArrayList<>();
    }

    @Getter
    @Setter
    private LocalDateTime arrivalTime;

    @Getter
    @Setter
    private List<Consultation> consultationList;

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
                "score=" + score +
                ", consultationList=" + consultationList +
                ", questionnaire=" + questionnaire;
    }
}

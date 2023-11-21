package br.edu.infnet.apphospitalar.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Consultation {

    public Consultation() {

    }

    public Consultation(Doctor doctor, Patient patient, LocalDateTime consultationDateTime, String consultationDescription, double consultationValue, String id) {
       this.doctor = doctor;
       this.patient = patient;
       this.consultationDateTime = consultationDateTime;
       this.consultationDescription = consultationDescription;
       this.consultationValue = consultationValue;
       this.id = id;
    }

    @Getter
    @Setter
    private Doctor doctor;

    @Getter
    @Setter
    private Patient patient;

    @Getter
    @Setter
    private LocalDateTime consultationDateTime;

    @Getter
    @Setter
    private String consultationDescription;

    @Getter
    @Setter
    private double consultationValue;

    @Getter
    @Setter
    private String id;

    @Override
    public String toString() {
        return "Consultation:" +
                "doctor=" + doctor +
                ", patient=" + patient +
                ", consultationDateTime=" + consultationDateTime +
                ", consultationDescription='" + consultationDescription + '\'' +
                ", consultationValue=" + consultationValue +
                ", id='" + id;
    }
}

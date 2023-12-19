package br.edu.infnet.apphospitalar.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Remove;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
public class Consultation {

    public Consultation() {

    }

    public Consultation(Doctor doctor, Patient patient, LocalDateTime consultationDateTime, String consultationDescription, double consultationValue) {
       this.doctor = doctor;
       this.patient = patient;
       this.consultationDateTime = consultationDateTime;
       this.consultationDescription = consultationDescription;
       this.consultationValue = consultationValue;
    }

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    @Getter
    @Setter
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "patient_id")
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Override
    public String toString() {
        return "Consultation:" +
                "doctor=" + doctor.getFullName() +
                ", patient=" + patient.getFullName() +
                ", consultationDateTime=" + consultationDateTime +
                ", consultationDescription='" + consultationDescription + '\'' +
                ", consultationValue=" + consultationValue +
                ", id='" + id;
    }
}

package br.edu.infnet.apphospitalar.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Entity
public class HospitalQueue implements Comparable<HospitalQueue> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @OneToOne
    @Getter
    @Setter
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Getter
    @Setter
    private int score;

    @Getter
    @Setter
    private int position;
    public void calculateScore() {
        if (patient != null && patient.getQuestionnaire() != null) {
            MedicalQuestionnaire questionnaire = patient.getQuestionnaire();
            int calculatedScore = 0;
            if (questionnaire.isPregnant()) {
                calculatedScore += 5;
            }
            if(questionnaire.isPersonWithDisabilities()) {
                calculatedScore += 5;
            }
            if(questionnaire.isHasChronicCondition()) {
                calculatedScore += 5;
            }
            setScore(calculatedScore);
        }
    }
    @Override
    public int compareTo(HospitalQueue other) {
        return Comparator.comparing(HospitalQueue::getScore, Comparator.reverseOrder())
                .thenComparing(p -> p.getPatient().getBirthDate(), Comparator.naturalOrder())
                .compare(this, other);
    }

    public HospitalQueue() {

    }

    @Override
    public String toString() {
        return "Queue Position: "+position+
                ", score: "+score+
                ", patient: "+patient.toString();
    }

}

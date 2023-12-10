package br.edu.infnet.apphospitalar.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class MedicalQuestionnaire {

    public MedicalQuestionnaire(boolean hasChronicCondition, String symptomsDescription, String medicalHistory, boolean isPregnant, boolean isPersonWithDisabilities) {
        this.hasChronicCondition=hasChronicCondition;
        this.symptomsDescription = symptomsDescription;
        this.medicalHistory = medicalHistory;
        this.isPregnant = isPregnant;
        this.isPersonWithDisabilities = isPersonWithDisabilities;
    }

    @Getter
    @Setter
    private boolean hasChronicCondition;

    @Getter
    @Setter
    private String symptomsDescription;

    @Getter
    @Setter
    private String medicalHistory;

    @Getter
    @Setter
    private boolean isPersonWithDisabilities;

    @Getter
    @Setter
    private boolean isPregnant;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    public MedicalQuestionnaire() {

    }
    public MedicalQuestionnaire(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MedicalQuestionnaire: " +
                "hasChronicCondition=" + hasChronicCondition +
                ", symptomsDescription='" + symptomsDescription + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", isPersonWithDisabilities=" + isPersonWithDisabilities +
                ", isPregnant=" + isPregnant +
                ", id='" + id;
    }
}

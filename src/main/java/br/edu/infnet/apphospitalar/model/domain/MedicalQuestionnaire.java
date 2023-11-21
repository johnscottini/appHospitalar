package br.edu.infnet.apphospitalar.model.domain;

import lombok.Getter;
import lombok.Setter;

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

    @Getter
    @Setter
    private String id;

    public MedicalQuestionnaire() {

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

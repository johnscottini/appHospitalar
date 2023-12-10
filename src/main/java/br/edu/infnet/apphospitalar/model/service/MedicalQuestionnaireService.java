package br.edu.infnet.apphospitalar.model.service;

import br.edu.infnet.apphospitalar.model.domain.MedicalQuestionnaire;
import br.edu.infnet.apphospitalar.model.repositories.MedicalQuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MedicalQuestionnaireService {

    @Autowired
    private MedicalQuestionnaireRepository medicalQuestionnaireRepository;

    public void insert(MedicalQuestionnaire medicalQuest) {
        medicalQuestionnaireRepository.save(medicalQuest);
    }

    public Collection<MedicalQuestionnaire> getList() {
        return (Collection<MedicalQuestionnaire>) medicalQuestionnaireRepository.findAll();
    }
}

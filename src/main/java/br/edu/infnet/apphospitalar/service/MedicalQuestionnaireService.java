package br.edu.infnet.apphospitalar.service;

import br.edu.infnet.apphospitalar.model.domain.MedicalQuestionnaire;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicalQuestionnaireService {

    private Map<String, MedicalQuestionnaire> map = new HashMap<String, MedicalQuestionnaire>();

    public void insert(MedicalQuestionnaire medicalQuest) {
        map.put(medicalQuest.getId(), medicalQuest);
    }

    public Collection<MedicalQuestionnaire> getList() {
        return map.values();
    }
}

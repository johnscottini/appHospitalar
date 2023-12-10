package br.edu.infnet.apphospitalar.model.repositories;

import br.edu.infnet.apphospitalar.model.domain.MedicalQuestionnaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalQuestionnaireRepository extends CrudRepository<MedicalQuestionnaire,Long> {
}

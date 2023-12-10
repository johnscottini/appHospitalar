package br.edu.infnet.apphospitalar.model.repositories;

import br.edu.infnet.apphospitalar.model.domain.Consultation;
import org.springframework.data.repository.CrudRepository;

public interface ConsultationRepository extends CrudRepository<Consultation, Long> {
}

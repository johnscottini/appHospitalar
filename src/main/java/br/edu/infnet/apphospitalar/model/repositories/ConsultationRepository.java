package br.edu.infnet.apphospitalar.model.repositories;

import br.edu.infnet.apphospitalar.model.domain.Consultation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsultationRepository extends CrudRepository<Consultation, Long> {
    List<Consultation> findByPatientId(Long id);
    List<Consultation> findByDoctorId(Long id);
}

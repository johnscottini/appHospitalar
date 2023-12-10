package br.edu.infnet.apphospitalar.model.repositories;

import br.edu.infnet.apphospitalar.model.domain.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}

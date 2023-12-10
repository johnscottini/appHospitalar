package br.edu.infnet.apphospitalar.model.repositories;

import br.edu.infnet.apphospitalar.model.domain.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}

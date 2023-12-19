package br.edu.infnet.apphospitalar.model.repositories;

import br.edu.infnet.apphospitalar.model.domain.HospitalQueue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HospitalQueueRepository extends CrudRepository<HospitalQueue, Long> {
    List<HospitalQueue> findAllByOrderByScoreDesc();

    List<HospitalQueue> findAllByOrderByPositionAsc();

   HospitalQueue findHospitalQueueByPatientId(Long id);
}

package br.edu.infnet.apphospitalar;

import br.edu.infnet.apphospitalar.model.domain.HospitalQueue;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.model.service.HospitalQueueService;
import br.edu.infnet.apphospitalar.model.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Order(6)
@Component
public class HospitalQueueLoader implements ApplicationRunner {
    @Autowired
    private HospitalQueueService hospitalQueueService;
    @Override
    public void run(ApplicationArguments args) throws Exception {


    }
}
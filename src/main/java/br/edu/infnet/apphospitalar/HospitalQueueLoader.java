package br.edu.infnet.apphospitalar;

import br.edu.infnet.apphospitalar.model.domain.HospitalQueue;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.service.HospitalQueueService;
import br.edu.infnet.apphospitalar.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class HospitalQueueLoader implements ApplicationRunner {
    @Autowired
    private HospitalQueueService hospitalQueueService;
    @Autowired
    private PatientService patientService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        HospitalQueue hospitalQueue = new HospitalQueue();

      Collection<Patient> patientList = patientService.getList();

        for (Patient p: patientList
             ) {
            hospitalQueueService.insertPatient(p);
        }

        for (Patient p: hospitalQueueService.getList()
             ) {
            System.out.println("Hospital queue - patient: "+ p);
        }
    }
}
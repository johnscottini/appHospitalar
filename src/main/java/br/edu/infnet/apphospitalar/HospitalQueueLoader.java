package br.edu.infnet.apphospitalar;

import br.edu.infnet.apphospitalar.model.domain.HospitalQueue;
import br.edu.infnet.apphospitalar.model.domain.MedicalQuestionnaire;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.model.service.HospitalQueueService;
import br.edu.infnet.apphospitalar.model.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Order(6)
@Component
public class HospitalQueueLoader implements ApplicationRunner {
    @Autowired
    private HospitalQueueService hospitalQueueService;

    @Autowired
    private PatientService patientService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Patient> patientsList = (List<Patient>) patientService.getList();

        for (Patient pat: patientsList
             ) {
            hospitalQueueService.enqueuePatient(pat);
        }

        System.out.println("Hospital Queue:");
        for(HospitalQueue hq : hospitalQueueService.getList()) {
            System.out.println(hq);
        }

    }
}
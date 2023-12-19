package br.edu.infnet.apphospitalar.model.controller;

import br.edu.infnet.apphospitalar.model.domain.Consultation;
import br.edu.infnet.apphospitalar.model.domain.HospitalQueue;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.model.repositories.ConsultationRepository;
import br.edu.infnet.apphospitalar.model.repositories.HospitalQueueRepository;
import br.edu.infnet.apphospitalar.model.service.ConsultationService;
import br.edu.infnet.apphospitalar.model.service.HospitalQueueService;
import br.edu.infnet.apphospitalar.model.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private HospitalQueueService hospitalQueueService;

    @Autowired
    private HospitalQueueRepository hospitalQueueRepository;

    @GetMapping(value = "/list")
    public List<Patient> getList() {
        return (List<Patient>) patientService.getList();
    }

    @PostMapping(value = "/insert")
    public void insert(@RequestBody Patient patient) {
        patientService.insertWithoutAddressAPI(patient);
        hospitalQueueService.enqueuePatient(patient);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable Long id) {
        List<Consultation> consultationList = consultationService.findAllConsultationsByPatientId(id);
        HospitalQueue hospitalQueue = hospitalQueueService.findHospitalQueueByPatientId(id);
        hospitalQueue.setPatient(null);
        hospitalQueueRepository.save(hospitalQueue);
        hospitalQueueRepository.delete(hospitalQueue);
        for (Consultation cons: consultationList
        ) {
            cons.setPatient(null);
            consultationRepository.save(cons);
            consultationService.delete(cons.getId());
        }
       patientService.delete(id);
    }

}

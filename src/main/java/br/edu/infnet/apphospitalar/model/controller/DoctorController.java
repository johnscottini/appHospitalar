package br.edu.infnet.apphospitalar.model.controller;

import br.edu.infnet.apphospitalar.model.domain.Consultation;
import br.edu.infnet.apphospitalar.model.domain.Doctor;
import br.edu.infnet.apphospitalar.model.domain.HospitalQueue;
import br.edu.infnet.apphospitalar.model.repositories.ConsultationRepository;
import br.edu.infnet.apphospitalar.model.service.ConsultationService;
import br.edu.infnet.apphospitalar.model.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {


    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private ConsultationRepository consultationRepository;

    @GetMapping(value = "/list")
    public List<Doctor> getList() {
        return (List<Doctor>) doctorService.getList();
    }

    @PostMapping(value = "/insert")
    public void insert(@RequestBody Doctor doctor) {
        doctorService.insertWithoutAddressAPI(doctor);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable Long id) {
        List<Consultation> consultationList = consultationService.findAllConsultationsByDoctorId(id);
        for (Consultation cons: consultationList
        ) {
            cons.setPatient(null);
            cons.setDoctor(null);
            consultationRepository.save(cons);
            consultationService.delete(cons.getId());
        }
        doctorService.delete(id);
    }

}

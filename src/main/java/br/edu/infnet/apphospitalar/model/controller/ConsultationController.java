package br.edu.infnet.apphospitalar.model.controller;

import br.edu.infnet.apphospitalar.model.domain.Consultation;
import br.edu.infnet.apphospitalar.model.repositories.ConsultationRepository;
import br.edu.infnet.apphospitalar.model.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private ConsultationRepository consultationRepository;

    @GetMapping(value = "/list")
    public List<Consultation> getList() {
        return (List<Consultation>) consultationService.getList();
    }

    @PostMapping(value = "/insert")
    public void insert(@RequestBody Consultation consultation) {
        consultationService.insert(consultation);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable Long id) {
        List<Consultation> consultationList = consultationService.findAllConsultationsByPatientId(id);
        for (Consultation cons: consultationList
        ) {
            cons.setPatient(null);
            consultationRepository.save(cons);
            consultationService.delete(cons.getId());
        }
    }

}

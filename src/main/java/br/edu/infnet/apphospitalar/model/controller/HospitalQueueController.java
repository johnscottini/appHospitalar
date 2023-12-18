package br.edu.infnet.apphospitalar.model.controller;

import br.edu.infnet.apphospitalar.model.domain.Consultation;
import br.edu.infnet.apphospitalar.model.domain.HospitalQueue;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.model.service.ConsultationService;
import br.edu.infnet.apphospitalar.model.service.HospitalQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitalQueue")
public class HospitalQueueController {

    @Autowired
    private HospitalQueueService hospitalQueueService;

    @GetMapping(value = "/list")
    public List<HospitalQueue> getList() {
        return (List<HospitalQueue>) hospitalQueueService.getList();
    }


    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable Long id) {
        hospitalQueueService.delete(id);
    }

}

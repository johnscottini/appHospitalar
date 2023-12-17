package br.edu.infnet.apphospitalar.model.controller;

import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.model.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {


    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/list")
    public List<Patient> getList() {
        return (List<Patient>) patientService.getList();
    }

    @PostMapping(value = "/insert")
    public void insert(Patient patient) {
        patientService.insert(patient);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable Long id) {
        patientService.delete(id);
    }

}

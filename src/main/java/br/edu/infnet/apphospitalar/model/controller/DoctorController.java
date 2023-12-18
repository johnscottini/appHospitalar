package br.edu.infnet.apphospitalar.model.controller;

import br.edu.infnet.apphospitalar.model.domain.Doctor;
import br.edu.infnet.apphospitalar.model.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {


    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "/list")
    public List<Doctor> getList() {
        return (List<Doctor>) doctorService.getList();
    }

    @PostMapping(value = "/insert")
    public void insert(@RequestBody Doctor doctor) {
        doctorService.insert(doctor);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable Long id) {
        doctorService.delete(id);
    }

}

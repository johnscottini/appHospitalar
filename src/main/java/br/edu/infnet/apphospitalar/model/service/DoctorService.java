package br.edu.infnet.apphospitalar.model.service;

import br.edu.infnet.apphospitalar.model.domain.Doctor;
import br.edu.infnet.apphospitalar.model.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void insert(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public Collection<Doctor> getList() {
        return (Collection<Doctor>) doctorRepository.findAll();
    }
}

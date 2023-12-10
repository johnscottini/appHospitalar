package br.edu.infnet.apphospitalar.model.service;

import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.model.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public void insert(Patient patient) {
        patientRepository.save(patient);
    }

    public Collection<Patient> getList() {
        return (Collection<Patient>) patientRepository.findAll();
    }
}

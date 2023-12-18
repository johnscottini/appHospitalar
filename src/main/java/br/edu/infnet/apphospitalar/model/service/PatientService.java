package br.edu.infnet.apphospitalar.model.service;

import br.edu.infnet.apphospitalar.model.domain.Address;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.model.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AddressService addressService;

    public void insert(Patient patient) {
        String postalCode = patient.getAddress().getPostalCode();
        Address address = addressService.searchPostalCode(postalCode);
        patient.setAddress(address);
        patientRepository.save(patient);
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    public Collection<Patient> getList() {
        return (Collection<Patient>) patientRepository.findAll();
    }
}

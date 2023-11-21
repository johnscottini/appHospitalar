package br.edu.infnet.apphospitalar.service;

import br.edu.infnet.apphospitalar.model.domain.Doctor;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

@Service
public class DoctorService {

    private Map<String, Doctor> map = new HashMap<String, Doctor>();

    public void insert(Doctor doctor) {
        map.put(doctor.getCpf(), doctor);
    }

    public Collection<Doctor> getList() {
        return map.values();
    }
}

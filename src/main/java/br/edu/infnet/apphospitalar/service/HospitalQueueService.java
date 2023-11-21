package br.edu.infnet.apphospitalar.service;

import br.edu.infnet.apphospitalar.model.domain.HospitalQueue;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

@Service
public class HospitalQueueService {

    private Map<String, Patient> map = new HashMap<String, Patient>();

    public void insertPatient(Patient patient) {
        map.put(patient.getCpf(), patient);
    }

    public Collection<Patient> getList() {
        return map.values();
    }
}

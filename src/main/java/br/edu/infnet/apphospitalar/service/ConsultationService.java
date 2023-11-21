package br.edu.infnet.apphospitalar.service;

import br.edu.infnet.apphospitalar.model.domain.Address;
import br.edu.infnet.apphospitalar.model.domain.Consultation;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsultationService {

    private Map<String, Consultation> map = new HashMap<String, Consultation>();

    public void insert(Consultation consultation) {
        map.put(consultation.getId(), consultation);
    }

    public Collection<Consultation> getList() {
        return map.values();
    }
}

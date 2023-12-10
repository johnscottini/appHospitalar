package br.edu.infnet.apphospitalar.model.service;

import br.edu.infnet.apphospitalar.model.domain.Consultation;
import br.edu.infnet.apphospitalar.model.domain.Doctor;
import br.edu.infnet.apphospitalar.model.repositories.ConsultationRepository;
import br.edu.infnet.apphospitalar.model.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ConsultationService {
    @Autowired
    private PatientService ps;

    @Autowired
    private ConsultationRepository consultationRepository;

    public void insert(Consultation consultation) {
        consultationRepository.save(consultation);
    }

    public Collection<Consultation> getList() {
        return (Collection<Consultation>) consultationRepository.findAll();
    }
}

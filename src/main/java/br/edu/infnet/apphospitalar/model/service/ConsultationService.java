package br.edu.infnet.apphospitalar.model.service;

import br.edu.infnet.apphospitalar.model.domain.Consultation;
import br.edu.infnet.apphospitalar.model.domain.Doctor;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.model.repositories.ConsultationRepository;
import br.edu.infnet.apphospitalar.model.repositories.DoctorRepository;
import br.edu.infnet.apphospitalar.model.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private PatientRepository patientRepository;
    @Transactional
    public void insert(Consultation consultation) {
    consultationRepository.save(consultation);

    }

    public Collection<Consultation> getList() {
        return (Collection<Consultation>) consultationRepository.findAll();
    }
}

package br.edu.infnet.apphospitalar.model.service;

import br.edu.infnet.apphospitalar.model.domain.Consultation;
import br.edu.infnet.apphospitalar.model.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Transactional
    public void insert(Consultation consultation) {
    consultationRepository.save(consultation);
    }

    public List<Consultation> findAllConsultationsByPatientId(Long id){
        return consultationRepository.findByPatientId(id);
    }

    public Collection<Consultation> getList() {
        return (Collection<Consultation>) consultationRepository.findAll();
    }

    public void delete(Long id) {
        consultationRepository.deleteById(id);
    }

    public List<Consultation> findAllConsultationsByDoctorId(Long id) {
        return consultationRepository.findByDoctorId(id);
    }
}

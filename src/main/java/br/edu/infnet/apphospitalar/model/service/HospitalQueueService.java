package br.edu.infnet.apphospitalar.model.service;

import br.edu.infnet.apphospitalar.model.domain.HospitalQueue;
import br.edu.infnet.apphospitalar.model.domain.MedicalQuestionnaire;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.model.repositories.HospitalQueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class HospitalQueueService {
    @Autowired
    private HospitalQueueRepository hospitalQueueRepository;

    public void enqueuePatient(Patient patient) {
        HospitalQueue hospitalQueue = new HospitalQueue();
        hospitalQueue.setPatient(patient);
        hospitalQueue.calculateScore();
        hospitalQueueRepository.save(hospitalQueue);
        updatePatientPositions();
    }

    public void updatePatientPositions() {
        List<HospitalQueue> hospitalQueueList = hospitalQueueRepository.findAllByOrderByScoreDesc();

        Collections.sort(hospitalQueueList);

        for (int i = 0; i < hospitalQueueList.size(); i++) {
            HospitalQueue patient = hospitalQueueList.get(i);
            patient.setPosition(i + 1);
        }
        hospitalQueueRepository.saveAll(hospitalQueueList);
    }

    public Collection<HospitalQueue> getList() {
        return (Collection<HospitalQueue>) hospitalQueueRepository.findAllByOrderByPositionAsc();
    }
}

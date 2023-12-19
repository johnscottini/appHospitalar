package br.edu.infnet.apphospitalar.model.service;

import br.edu.infnet.apphospitalar.model.domain.HospitalQueue;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.model.repositories.HospitalQueueRepository;
import br.edu.infnet.apphospitalar.model.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HospitalQueueService {
    @Autowired
    private HospitalQueueRepository hospitalQueueRepository;

    @Autowired
    private PatientRepository patientRepository;

    public void enqueuePatient(Patient patient) {
        HospitalQueue hospitalQueue = new HospitalQueue();
        hospitalQueue.setPatient(patient);
        hospitalQueue.calculateScore();
        hospitalQueueRepository.save(hospitalQueue);
        updatePatientPositions();
        updatePatientScore(hospitalQueue);
    }

    public void updatePatientScore(HospitalQueue hospitalQueue) {
        Patient patient = hospitalQueue.getPatient();
        patient.setScore(hospitalQueue.getScore());
        patientRepository.save(patient);
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

    public void delete(Long id) {
        hospitalQueueRepository.deleteById(id);
    }

    public void updateQueue() {
        List<Patient> patientList = (List<Patient>) patientRepository.findAll();
        for (Patient pat: patientList
        ) {
            enqueuePatient(pat);
        }
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public HospitalQueue findHospitalQueueByPatientId(Long id) {
        return hospitalQueueRepository.findHospitalQueueByPatientId(id);
    }
}

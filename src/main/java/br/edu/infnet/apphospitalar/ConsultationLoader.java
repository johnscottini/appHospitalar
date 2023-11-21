package br.edu.infnet.apphospitalar;

import br.edu.infnet.apphospitalar.model.domain.*;
import br.edu.infnet.apphospitalar.service.ConsultationService;
import br.edu.infnet.apphospitalar.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class ConsultationLoader implements ApplicationRunner {
    @Autowired
    private ConsultationService consultationService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/consultations.txt");
        BufferedReader reader = new BufferedReader(file);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        String line = reader.readLine();
        String[] fields = null;

        while (line != null) {
            fields = line.split(";");
            Patient patient = new Patient();
            patient.setFullName(fields[0]);
            patient.setEmail(fields[1]);
            patient.setCpf(fields[2]);
            //patient.setScore(PatientService.calculateScore(patient));
            LocalDate birthDate = LocalDate.parse(fields[3], formatter);
            patient.setBirthDate(birthDate);
            LocalDateTime arrivalTime = LocalDateTime.parse(fields[4], formatterTime);
            patient.setArrivalTime(arrivalTime);

            Address address = new Address();
            address.setStreet(fields[5]);
            address.setCity(fields[6]);
            address.setNumber(fields[7]);
            address.setState(fields[8]);
            address.setPostalCode(fields[9]);
            address.setId(fields[10]);
            patient.setAddress(address);

            MedicalQuestionnaire questionnaire = new MedicalQuestionnaire();
            questionnaire.setMedicalHistory(fields[11]);
            questionnaire.setSymptomsDescription(fields[12]);
            questionnaire.setPregnant(Boolean.parseBoolean((fields[13])));
            questionnaire.setHasChronicCondition(Boolean.parseBoolean(fields[14]));
            questionnaire.setPersonWithDisabilities(Boolean.parseBoolean(fields[15]));
            questionnaire.setId(fields[16]);
            patient.setQuestionnaire(questionnaire);
            patient.setConsultationList(new ArrayList<>());
            //patient.setScore(MedicalQuestionnaireService.calculateScore(questionnaire, patient));

            Consultation consultation = new Consultation();
            consultation.setConsultationDescription(fields[17]);
            consultation.setConsultationValue(Double.parseDouble(fields[18]));
            consultation.setConsultationDateTime(LocalDateTime.parse(fields[19], formatterTime));
            consultation.setId(fields[20]);
            consultation.setPatient(patient);

            Doctor doctor = new Doctor();
            doctor.setConsultationList(new ArrayList<>());

            doctor.setFullName(fields[21]);
            doctor.setEmail(fields[22]);
            doctor.setCpf(fields[23]);
            doctor.setBirthDate(LocalDate.parse(fields[24], formatter));
            doctor.setSpecialty(fields[25]);
            doctor.setCrm(fields[26]);

            Address doctorAddress = new Address();
            doctorAddress.setStreet(fields[27]);
            doctorAddress.setCity(fields[28]);
            doctorAddress.setNumber(fields[29]);
            doctorAddress.setState(fields[30]);
            doctorAddress.setPostalCode(fields[31]);
            doctorAddress.setId(fields[32]);
            doctor.setAddress(doctorAddress);
            consultation.setDoctor(doctor);

            consultationService.insert(consultation);
            line = reader.readLine();
        }

        for(Consultation c : consultationService.getList()) {
            System.out.println("Consultation: "+ c);
        }

    }
}

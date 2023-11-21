package br.edu.infnet.apphospitalar;

import br.edu.infnet.apphospitalar.model.domain.Address;
import br.edu.infnet.apphospitalar.model.domain.MedicalQuestionnaire;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.service.PatientService;
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
public class PatientLoader implements ApplicationRunner {
    @Autowired
    private PatientService patientService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/patients.txt");
        BufferedReader reader = new BufferedReader(file);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        String line = reader.readLine();
        String[] fields = null;
        while(line != null) {
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

            patientService.insert(patient);
            line = reader.readLine();
        }

        for(Patient p : patientService.getList()) {
            System.out.println("Patient: "+ p);
        }

    }
}

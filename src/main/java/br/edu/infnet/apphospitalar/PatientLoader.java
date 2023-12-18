package br.edu.infnet.apphospitalar;

import br.edu.infnet.apphospitalar.model.domain.Address;
import br.edu.infnet.apphospitalar.model.domain.MedicalQuestionnaire;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import br.edu.infnet.apphospitalar.model.service.AddressService;
import br.edu.infnet.apphospitalar.model.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Component
@Order(4)
public class PatientLoader implements ApplicationRunner {
    @Autowired
    private PatientService patientService;

    @Autowired
    private AddressService addressService;

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
            LocalDate birthDate = LocalDate.parse(fields[3], formatter);
            patient.setBirthDate(birthDate);
            LocalDateTime arrivalTime = LocalDateTime.parse(fields[4], formatterTime);
            patient.setArrivalTime(arrivalTime);
            Address address = addressService.searchPostalCode(fields[5]);
            patient.setAddress(address);
            patient.setQuestionnaire(new MedicalQuestionnaire(Long.valueOf(fields[6])));
            patient.setConsultationList(new ArrayList<>());
            patientService.insert(patient);
            line = reader.readLine();
        }

        for(Patient p : patientService.getList()) {
            System.out.println("Patient: "+ p);
        }

    }
}

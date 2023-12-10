package br.edu.infnet.apphospitalar;

import br.edu.infnet.apphospitalar.model.domain.*;
import br.edu.infnet.apphospitalar.model.service.ConsultationService;
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

@Order(5)
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

            Consultation consultation = new Consultation();
            consultation.setPatient(new Patient(Long.valueOf(fields[0])));
            consultation.setConsultationDescription(fields[1]);
            consultation.setConsultationValue(Double.parseDouble(fields[2]));
            consultation.setConsultationDateTime(LocalDateTime.parse(fields[3], formatterTime));

            consultation.setDoctor(new Doctor(Long.valueOf(fields[4])));


            consultationService.insert(consultation);
            line = reader.readLine();
        }

        for(Consultation c : consultationService.getList()) {
            System.out.println("Consultation: "+ c);
        }

    }
}

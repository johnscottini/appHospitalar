package br.edu.infnet.apphospitalar;

import br.edu.infnet.apphospitalar.model.domain.MedicalQuestionnaire;
import br.edu.infnet.apphospitalar.service.MedicalQuestionnaireService;
import br.edu.infnet.apphospitalar.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.format.DateTimeFormatter;

@Component
public class MedicalQuestionnaireLoader implements ApplicationRunner {
    @Autowired
    private MedicalQuestionnaireService medicalQuestionnaireService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/medicalQuestionnaires.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields = null;

        while(line != null) {

            fields = line.split(";");

            MedicalQuestionnaire questionnaire = new MedicalQuestionnaire();
            questionnaire.setMedicalHistory(fields[0]);
            questionnaire.setSymptomsDescription(fields[1]);
            questionnaire.setPregnant(Boolean.parseBoolean((fields[2])));
            questionnaire.setHasChronicCondition(Boolean.parseBoolean(fields[3]));
            questionnaire.setPersonWithDisabilities(Boolean.parseBoolean(fields[4]));
            questionnaire.setId(fields[5]);

            medicalQuestionnaireService.insert(questionnaire);

            line = reader.readLine();
        }

        for(MedicalQuestionnaire m : medicalQuestionnaireService.getList()) {
            System.out.println("Medical questionnaire: "+ m);
        }

    }
}

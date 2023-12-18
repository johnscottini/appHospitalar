package br.edu.infnet.apphospitalar.model.controller;

import br.edu.infnet.apphospitalar.model.domain.MedicalQuestionnaire;
import br.edu.infnet.apphospitalar.model.service.MedicalQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questionnaire")
public class MedicalQuestionnaireController {


    @Autowired
    private MedicalQuestionnaireService medicalQuestionnaireService;

    @GetMapping(value = "/list")
    public List<MedicalQuestionnaire> getList() {
        return (List<MedicalQuestionnaire>) medicalQuestionnaireService.getList();
    }

    @PostMapping(value = "/insert")
    public void insert(@RequestBody MedicalQuestionnaire medicalQuestionnaire) {
        medicalQuestionnaireService.insert(medicalQuestionnaire);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable Long id) {
        medicalQuestionnaireService.delete(id);
    }

}

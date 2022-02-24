package com.mediscreen.assessment.controller;

import com.mediscreen.assessment.service.AssessmentService;
import com.mediscreen.assessment.util.AssessmentResponseDTO;
import com.mediscreen.assessment.util.PatientStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }


    @RequestMapping(value = { "assessment/{patId}" })
    public AssessmentResponseDTO getPatientAssessment(@PathVariable("patId") Long patId){
        return assessmentService.getPatientAssessment(patId);
    }

    @RequestMapping(value = { "assess/id" },method = RequestMethod.POST)
    public String getPatientAssess(@RequestParam("patId") Long patId){
        AssessmentResponseDTO assessmentResponseDTO= assessmentService.getPatientAssessment(patId);
        String response= "Patient : ".concat(assessmentResponseDTO.getPatient())
                .concat(" (").concat(String.valueOf(assessmentResponseDTO.getAge())).concat(" )").concat(" diabetes assessment is: ")
                .concat(assessmentResponseDTO.getPatientStatus());
        return response;
    }

}

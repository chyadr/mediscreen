package com.mediscreen.assessment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.assessment.ConstantsTest;
import com.mediscreen.assessment.service.AssessmentService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
 @WebMvcTest(AssessmentController.class)
public class AssessmentControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private AssessmentService assessmentService;

    @Test
    public void givenAssessment_whenGetPatientAssessment_thenReturnPatientAssessment() throws Exception {
        when(assessmentService.getPatientAssessment(anyLong())).thenReturn(ConstantsTest.assessmentResponseDTO);

             mvc.perform(get("/assessment/1")
                                         .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk())
                     .andExpect(jsonPath("$.patient", is("patient")));

          }


    @Test
    public void givenAssessment_whenGetPatientAssess_thenReturnPatientAssessment() throws Exception {
        when(assessmentService.getPatientAssessment(anyLong())).thenReturn(ConstantsTest.assessmentResponseDTO);

        mvc.perform(post("/assess/id").param("patId","1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }


}
package com.mediscreen.patient.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.patient.ConstantsTest;
import com.mediscreen.patient.controller.PatientController;
import com.mediscreen.patient.service.PatientService;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
 @WebMvcTest(PatientController.class)
public class PatientControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private PatientService patientService;

    @Test
    public void givenSlash_whenFindAllPatients_thenReturnPatients() throws Exception {
        when(patientService.findAllPatients()).thenReturn(ConstantsTest.patients);

             mvc.perform(get("/patient/")
                                         .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
                     .andExpect(jsonPath("$[0].family", is("family")));

          }


    @Test
    public void givenSlashWithId_whenFindPatient_thenReturnPatient() throws Exception {
        when(patientService.findPatient(anyLong())).thenReturn(ConstantsTest.patient);

        mvc.perform(get("/patient/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.family", is("family")));

    }

    @Test
    public void givenPatient_whenCreatePatient_thenReturnPatient() throws Exception {
        when(patientService.createPatient(any())).thenReturn(ConstantsTest.patient);

        mvc.perform(post("/patient/createPatient").content(objectMapper.writeValueAsString(ConstantsTest.patient))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.family", is("family")));

    }

    @Test
    public void givenPatient_whenAddPatient_thenReturnPatient() throws Exception {
        when(patientService.createPatient(any())).thenReturn(ConstantsTest.patient);

        mvc.perform(post("/patient/add").param("family","family")
                        .param("given","given")
                        .param("dob",LocalDate.now().minus(1, ChronoUnit.YEARS).toString())
                        .param("sex","F")
                        .param("address","address")
                        .param("phone","0101010101")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());


    }

    @Test
    public void givenPatient_whenUpdatePatient_thenReturnPatient() throws Exception {
        when(patientService.updatePatient(any())).thenReturn(ConstantsTest.patient);

        mvc.perform(put("/patient/updatePatient").content(objectMapper.writeValueAsString(ConstantsTest.patient))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.family", is("family")));

    }


    @Test
    public void givenId_whenDeletePatient_thenReturnNothing() throws Exception {
        doNothing().when(patientService).deletePatient(anyLong());

        mvc.perform(delete("/patient/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }
}
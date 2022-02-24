package com.mediscreen.note.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.note.ConstantsTest;
import com.mediscreen.note.service.PatHistoryService;
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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
 @WebMvcTest(PatHistoryController.class)
public class PatientHistoryControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private PatHistoryService patHistoryService;

    @Test
    public void givenPatientId_whenFindAllNotesById_thenReturnNotes() throws Exception {
        when(patHistoryService.findAllByPatId(anyLong())).thenReturn(ConstantsTest.notes);

             mvc.perform(get("/patHistory/findAllByPatId/1")
                                         .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
                     .andExpect(jsonPath("$[0].patient", is("patient")));

          }


    @Test
    public void givenNoteId_whenFindNote_thenReturnNote() throws Exception {
        when(patHistoryService.findById(anyString())).thenReturn(ConstantsTest.note);

        mvc.perform(get("/patHistory/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patient", is("patient")));

    }

    @Test
    public void givenNote_whenCreateNote_thenReturnNote() throws Exception {
        when(patHistoryService.createPatHistory(any())).thenReturn(ConstantsTest.note);

        mvc.perform(post("/patHistory/createPatHistory").content(objectMapper.writeValueAsString(ConstantsTest.note))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patient", is("patient")));

    }

    @Test
    public void givenNote_whenAddNote_thenReturnNote() throws Exception {
        when(patHistoryService.createPatHistory(any())).thenReturn(ConstantsTest.note);

        mvc.perform(post("/patHistory/add")
                        .param("patId","1¬e=Patient: TestNone Practitioner's notes/recommendations: Patient states that they are 'feeling terrific' Weight at or below recommended level")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }

    @Test
    public void givenNote_whenUpdateNote_thenReturnNote() throws Exception {
        when(patHistoryService.updatePatHistory(any())).thenReturn(ConstantsTest.note);

        mvc.perform(put("/patHistory/updatePatHistory").content(objectMapper.writeValueAsString(ConstantsTest.note))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patient", is("patient")));

    }


    @Test
    public void givenId_whenDeletePatient_thenReturnNothing() throws Exception {
        doNothing().when(patHistoryService).deletePatHistory(anyString());

        mvc.perform(delete("/patHistory/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }
}
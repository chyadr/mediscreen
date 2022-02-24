package com.mediscreen.assessment.service;

import com.mediscreen.assessment.ConstantsTest;
import com.mediscreen.assessment.client.NoteClient;
import com.mediscreen.assessment.client.PatientClient;
import com.mediscreen.assessment.service.AssessmentService;
import com.mediscreen.assessment.util.AssessmentResponseDTO;
import com.mediscreen.assessment.util.PatientStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AssessmentServiceTest {

    @InjectMocks
    private AssessmentService assessmentService;
    @Mock
    private NoteClient noteClient;
    @Mock
    private PatientClient patientClient;


    @Test
    public void givenPatientId_whenGetPatientAssessment_thenReturnAssessmentResponseDTO_None() {
        when(noteClient.findNotesByPatientId(anyLong())).thenReturn(ConstantsTest.noteDTOsNone);
        when(patientClient.findPatientById(anyLong())).thenReturn(ConstantsTest.patientDTO_PLUS_30);
        AssessmentResponseDTO assessmentResponseDTO =assessmentService.getPatientAssessment(1L);
        assertNotNull(assessmentResponseDTO);
        assertEquals("None",assessmentResponseDTO.getPatientStatus());
    }

    @Test
    public void givenPatientId_whenGetPatientAssessment_thenReturnAssessmentResponseDTO_Border_Line() {
        when(noteClient.findNotesByPatientId(anyLong())).thenReturn(ConstantsTest.noteDTOsBorderLine);
        when(patientClient.findPatientById(anyLong())).thenReturn(ConstantsTest.patientDTO_PLUS_30);
        AssessmentResponseDTO assessmentResponseDTO =assessmentService.getPatientAssessment(1L);
        assertNotNull(assessmentResponseDTO);
        assertEquals("BorderLine",assessmentResponseDTO.getPatientStatus());
    }


    @Test
    public void givenPatientId_whenGetPatientAssessment_thenReturnAssessmentResponseDTO_In_Danger() {
        when(noteClient.findNotesByPatientId(anyLong())).thenReturn(ConstantsTest.noteDTOsInDanger);
        when(patientClient.findPatientById(anyLong())).thenReturn(ConstantsTest.patientDTO_MINUS_30);
        AssessmentResponseDTO assessmentResponseDTO =assessmentService.getPatientAssessment(1L);
        assertNotNull(assessmentResponseDTO);
        assertEquals("In Danger",assessmentResponseDTO.getPatientStatus());
    }

    @Test
    public void givenPatientId_whenGetPatientAssessment_thenReturnAssessmentResponseDTO_Early_Onset() {
        when(noteClient.findNotesByPatientId(anyLong())).thenReturn(ConstantsTest.noteDTOsEarlyOnset);
        when(patientClient.findPatientById(anyLong())).thenReturn(ConstantsTest.patientDTO_PLUS_30);
        AssessmentResponseDTO assessmentResponseDTO =assessmentService.getPatientAssessment(1L);
        assertNotNull(assessmentResponseDTO);
        assertEquals("Early Onset",assessmentResponseDTO.getPatientStatus());
    }
}

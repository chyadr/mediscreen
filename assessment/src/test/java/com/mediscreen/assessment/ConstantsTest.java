package com.mediscreen.assessment;

import com.mediscreen.assessment.dto.Gender;
import com.mediscreen.assessment.dto.NoteDTO;
import com.mediscreen.assessment.dto.PatientDTO;
import com.mediscreen.assessment.util.AssessmentResponseDTO;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ConstantsTest {
    public static final PatientDTO patientDTO_MINUS_30 = new PatientDTO().family("family").given("given")
            .dob(ZonedDateTime.now().minus(18, ChronoUnit.YEARS)).sex(Gender.F).address("address").phoneNumber("0123456789");
    public static final PatientDTO patientDTO_PLUS_30 = new PatientDTO().family("family").given("given")
            .dob(ZonedDateTime.now().minus(40, ChronoUnit.YEARS)).sex(Gender.M).address("address").phoneNumber("0123456789");



    public static final List<NoteDTO> noteDTOsNone = List.of(new NoteDTO().patId(1L).patient("test")
            .note("Anormal"));

    public static final List<NoteDTO> noteDTOsBorderLine = List.of(new NoteDTO().patId(1L).patient("test")
            .note("AnormalFumeur"));

    public static final List<NoteDTO> noteDTOsInDanger = List.of(new NoteDTO().patId(1L).patient("test")
            .note("AnormalFumeurVertigeCholestérol"));

    public static final List<NoteDTO> noteDTOsEarlyOnset = List.of(new NoteDTO().patId(1L).patient("test")
            .note("AnormalFumeurVertigeCholestérolPoidsTailleAnticorpsRéaction"));


    public static final AssessmentResponseDTO assessmentResponseDTO = new AssessmentResponseDTO("patient",30,"None");
}
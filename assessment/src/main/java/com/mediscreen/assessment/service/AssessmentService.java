package com.mediscreen.assessment.service;

import com.mediscreen.assessment.client.NoteClient;
import com.mediscreen.assessment.client.PatientClient;
import com.mediscreen.assessment.dto.Gender;
import com.mediscreen.assessment.dto.NoteDTO;
import com.mediscreen.assessment.dto.PatientDTO;
import com.mediscreen.assessment.util.AssessmentResponseDTO;
import com.mediscreen.assessment.util.Constants;
import com.mediscreen.assessment.util.NoteTerms;
import com.mediscreen.assessment.util.PatientStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AssessmentService implements IAssessmentService {

    private final PatientClient patientClient;
    private final NoteClient noteClient;

    public AssessmentService(PatientClient patientClient, NoteClient noteClient) {
        this.patientClient = patientClient;
        this.noteClient = noteClient;
    }

    @Override
    public AssessmentResponseDTO getPatientAssessment(Long patientId) {

        PatientDTO patientDTO = patientClient.findPatientById(patientId);
        List<NoteDTO> noteDTOS = noteClient.findNotesByPatientId(patientId);

        int termsOccurrences = countTermsInNotes(noteDTOS);


        return getPatientStatus(patientDTO, termsOccurrences);
    }

    /**
     * Count terms in list of notes of a specific patient.
     * @param noteDTOS list of notes.
     * @return number of terms identified in notes.
     */
    private int countTermsInNotes(List<NoteDTO> noteDTOS) {
        return noteDTOS.stream().map(NoteDTO::getNote)
                .map(note ->
                        Arrays.stream(NoteTerms.values())
                                .map(term ->
                                        StringUtils.countOccurrencesOf(note.toUpperCase(), term.getTermsValue().toUpperCase())).collect(Collectors.toList()))
                .flatMap(List::stream).mapToInt(Integer::intValue).sum();
    }

    /**
     * Get Patient Status for a specific patient and depends on number of terms/age/sex.
     * @param patientDTO the patient.
     * @param termsOccurrences the number of terms already calculated from patient notes.
     * @return DTO containing all information related to the patient assessment.
     */
    private AssessmentResponseDTO getPatientStatus(PatientDTO patientDTO, int termsOccurrences) {
        int age = Period.between(patientDTO.getDob().toInstant().atZone(ZoneId.of("UTC")).toLocalDate(), LocalDate.now()).getYears();

        if (termsOccurrences == Constants.NB_OCCURRENCES_2 && age > Constants.AGE_30) {
            return getResponse(patientDTO.getFamily(),patientDTO.getGiven(),age,PatientStatus.BORDER_LINE);
        }
        if ((termsOccurrences == Constants.NB_OCCURRENCES_3 && patientDTO.getSex().equals(Gender.M) && age < Constants.AGE_30)
                || (termsOccurrences == Constants.NB_OCCURRENCES_4 && patientDTO.getSex().equals(Gender.F) && age < Constants.AGE_30)
                || (age > Constants.AGE_30 && termsOccurrences == Constants.NB_OCCURRENCES_6)) {
            return getResponse(patientDTO.getFamily(),patientDTO.getGiven(),age,PatientStatus.IN_DANGER);
        }
        if ((termsOccurrences == Constants.NB_OCCURRENCES_5 && patientDTO.getSex().equals(Gender.M) && age < Constants.AGE_30)
                || (termsOccurrences == Constants.NB_OCCURRENCES_7 && patientDTO.getSex().equals(Gender.F) && age < Constants.AGE_30)
                || (age > Constants.AGE_30 && termsOccurrences >= Constants.NB_OCCURRENCES_8)) {
            return getResponse(patientDTO.getFamily(),patientDTO.getGiven(),age,PatientStatus.EARLY_ONSET);
        }

        return getResponse(patientDTO.getFamily(),patientDTO.getGiven(),age,PatientStatus.NONE);
    }

    /**
     * method for concatenation of patient information.
     * @param family the family.
     * @param given the given.
     * @param age the age.
     * @param patientStatus the patient Status.
     * @return DTO containing assessment response.
     */
    private AssessmentResponseDTO getResponse (String family, String given, int age, PatientStatus patientStatus ){
        return new AssessmentResponseDTO(family.concat(" ").concat(given),age,patientStatus.getStatusValue());
    }
}

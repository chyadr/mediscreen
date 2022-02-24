package com.mediscreen.assessment.service;

import com.mediscreen.assessment.util.AssessmentResponseDTO;
import com.mediscreen.assessment.util.PatientStatus;

public interface IAssessmentService {

    /**
     * Get Patient Assessment by patient id.
     * @param patientId The patient id.
     * @return DTO containing all information related to patient assessment.
     */
    AssessmentResponseDTO getPatientAssessment(Long patientId);
}

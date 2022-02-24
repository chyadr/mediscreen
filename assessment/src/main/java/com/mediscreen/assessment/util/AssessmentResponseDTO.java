package com.mediscreen.assessment.util;

public class AssessmentResponseDTO {

    private String patient;
    private int age;
    private String patientStatus;


    public AssessmentResponseDTO(String patient, int age, String patientStatus) {
        this.patient = patient;
        this.age = age;
        this.patientStatus = patientStatus;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }
}

package com.mediscreen.patient.service;

import com.mediscreen.patient.model.Patient;

import java.util.List;

public interface IPatientService {
  /**
   * list all patients
   * @return list of all patients
   */
  List<Patient> findAllPatients();

  /**
   * list a patient by id
   * @return patient
   */
  Patient findPatient(Long id);

  /**
   * update an existing the patient
   * @param patient patient to be updated
   * @return the updated patient
   */
  Patient updatePatient(Patient patient);

  /**
   * create a new patient
   * @param patient the patient to be created
   * @return the created patient.
   */
  Patient createPatient(Patient patient);

  /**
   * delete a patient by id
   *
   */
  void deletePatient(Long id);
}

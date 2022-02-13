package com.mediscreen.patient.service;

import com.mediscreen.patient.ConstantsTest;
import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class PatientServiceTest {


    @InjectMocks
    private PatientService patientService;
    @Mock
    private PatientRepository patientRepository;


    @Test
    public void givenNothing_whenFindAllPatients_thenReturnList() {
        when(patientRepository.findAll()).thenReturn(ConstantsTest.patients);
        List<Patient> patients =patientService.findAllPatients();
        assertNotNull(patients);
        assertEquals(1, patients.size());
    }



    @Test
    public void givenPatientId_whenFindPatient_thenReturnPatient() {
        when(patientRepository.findById(anyLong())).thenReturn(Optional.of(ConstantsTest.patient));
        Patient patient =patientService.findPatient(1L);
        assertNotNull(patient);
    }


    @Test
    public void givenPatient_whenCreatePatient_thenReturnCreatedPatient() {
        when(patientRepository.save(any())).thenReturn(ConstantsTest.patient);
        Patient patient = patientService.createPatient(ConstantsTest.patient);
        assertNotNull(patient);
    }

    @Test
    public void givenPatient_whenUpdatePatient_thenReturnUpdatedPatient() {
        when(patientRepository.save(any())).thenReturn(ConstantsTest.patient);
        Patient patient = patientService.updatePatient(ConstantsTest.patient);
        assertNotNull(patient);
    }

    @Test
    public void givenPatientId_whenDeletePatient_thenVerify() {
       when(patientRepository.findById(anyLong())).thenReturn(Optional.of(ConstantsTest.patient));
        patientService.deletePatient(1L);
        verify(patientRepository,times(1)).delete(ConstantsTest.patient);
    }

}

package com.mediscreen.patient.controller;

import com.mediscreen.patient.model.Patient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.mediscreen.patient.service.PatientService;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientController {

private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @RequestMapping(value = { "/" })
    public List<Patient> findAllPatients(){
        return patientService.findAllPatients();
    }

    @RequestMapping(value = { "/{id}" })
    public Patient findPatient(@PathVariable("id") Long id){
        return patientService.findPatient(id);
    }

    @RequestMapping(value = { "/createPatient" }, method = RequestMethod.POST)
    public Patient createPatient(@RequestBody @Valid Patient patient){

        return patientService.createPatient(patient);
    }

    @RequestMapping(value = { "/updatePatient" }, method = RequestMethod.PUT)
    public Patient updatePatient(@RequestBody @Valid Patient patient){
        return patientService.updatePatient(patient);
    }

    @RequestMapping(value = { "/{id}" },method = RequestMethod.DELETE)
    public void deletePatient(@PathVariable("id") Long id){
        patientService.deletePatient(id);
    }

}

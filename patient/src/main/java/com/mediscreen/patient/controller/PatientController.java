package com.mediscreen.patient.controller;

import com.mediscreen.patient.model.Gender;
import com.mediscreen.patient.model.Patient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.mediscreen.patient.service.PatientService;

import javax.validation.Valid;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
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

    @RequestMapping(value = { "/add" }, method = RequestMethod.POST)
    public Patient addPatient(@RequestParam("family") String family,
                              @RequestParam("given") String given,
                              @RequestParam("dob") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dob,
                              @RequestParam("sex") String sex,
                              @RequestParam("address") String address,
                              @RequestParam("phone") String phone){
        Patient patient = new Patient();
        patient.setFamily(family);
        patient.setGiven(given);
        patient.setDob(dob.atStartOfDay().atZone(ZoneId.systemDefault()));
        patient.sex(Gender.valueOf(sex));
        patient.address(address);
        patient.setPhoneNumber(phone);


        return createPatient(patient);
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

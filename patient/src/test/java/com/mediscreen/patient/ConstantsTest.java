package com.mediscreen.patient;

import com.mediscreen.patient.model.Gender;
import com.mediscreen.patient.model.Patient;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

public class ConstantsTest {
    public static final Patient patient = new Patient().family("family").given("given")
            .dob(ZonedDateTime.now().minus(18, ChronoUnit.YEARS)).sex(Gender.F).address("address").phoneNumber("0123456789");


    public static final List<Patient> patients = Collections.singletonList(new Patient().family("family").given("given")
            .dob(ZonedDateTime.now().minus(18, ChronoUnit.YEARS)).sex(Gender.F).address("address").phoneNumber("0123456789"));


}
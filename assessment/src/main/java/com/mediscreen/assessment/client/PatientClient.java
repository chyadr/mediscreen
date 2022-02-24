package com.mediscreen.assessment.client;

import com.mediscreen.assessment.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="patient",url = "${patient.url}")
public interface PatientClient {

    @RequestMapping(method = RequestMethod.GET, value = "/patient/{id}")
    PatientDTO findPatientById(@PathVariable("id") Long id);
}

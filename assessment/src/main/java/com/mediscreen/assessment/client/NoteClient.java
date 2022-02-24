package com.mediscreen.assessment.client;

import com.mediscreen.assessment.dto.NoteDTO;
import com.mediscreen.assessment.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="note",url = "${note.url}")
public interface NoteClient {

    @RequestMapping(method = RequestMethod.GET, value = "/note/findAllByPatId/{patId}")
    List<NoteDTO> findNotesByPatientId(@PathVariable("patId") Long patId);
}

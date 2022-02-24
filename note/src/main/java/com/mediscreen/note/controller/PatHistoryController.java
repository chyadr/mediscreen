package com.mediscreen.note.controller;

import com.mediscreen.note.model.PatHistory;
import com.mediscreen.note.service.PatHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping( {"/note","patHistory"})
@CrossOrigin("*")
public class PatHistoryController {

    private final PatHistoryService patHistoryService;

    public PatHistoryController(PatHistoryService patHistoryService) {
        this.patHistoryService = patHistoryService;
    }

    @RequestMapping(value = { "/findAllByPatId/{patId}" })
    public List<PatHistory> findAllByPatId(@PathVariable("patId") Long patId){
        return patHistoryService.findAllByPatId(patId);
    }

    @RequestMapping(value = { "/{id}" })
    public PatHistory findById(@PathVariable("id") String id){
        return patHistoryService.findById(id);
    }

    @RequestMapping(value = { "/add" }, method = RequestMethod.POST)
    public PatHistory add(@RequestParam("patId") String patId){
        PatHistory patHistory = new PatHistory();
        patHistory.setPatId(Long.valueOf(patId.substring(0,patId.indexOf("e=")-1)));
        patHistory.setPatient(patId.substring(patId.indexOf("Patient: ") +"Patient: ".length(),patId.indexOf(" notes/recommendations: ")));
        patHistory.setNote(patId.substring(patId.indexOf(" notes/recommendations: ") +" notes/recommendations: ".length()));

        return createPatHistory(patHistory);
    }

    @RequestMapping(value = { "/createPatHistory" }, method = RequestMethod.POST)
    public PatHistory createPatHistory(@RequestBody @Valid PatHistory patHistory){

        return patHistoryService.createPatHistory(patHistory);
    }

    @RequestMapping(value = { "/updatePatHistory" }, method = RequestMethod.PUT)
    public PatHistory updatePatHistory(@RequestBody @Valid PatHistory patHistory){
        return patHistoryService.updatePatHistory(patHistory);
    }

    @RequestMapping(value = { "/{id}" },method = RequestMethod.DELETE)
    public void deletePatHistory(@PathVariable("id") String id){
        patHistoryService.deletePatHistory(id);
    }

}

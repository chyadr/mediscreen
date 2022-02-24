package com.mediscreen.note.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "patHistory")
public class PatHistory {


    @Id
    private String id;
    @NotNull (message = "Only not null values are accepted")
    private Long patId;
    @NotBlank (message = "Only not blank values are accepted")
    private String patient;
    @NotBlank (message = "Only not blank values are accepted")
    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public PatHistory patId (Long patId){
        this.patId=patId;
        return this;
    }

    public PatHistory patient (String patient){
        this.patient=patient;
        return this;
    }

    public PatHistory note (String note){
        this.note=note;
        return this;
    }
}

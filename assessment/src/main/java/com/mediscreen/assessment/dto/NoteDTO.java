package com.mediscreen.assessment.dto;


public class NoteDTO {


    private String id;
    private Long patId;
    private String patient;
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

    public NoteDTO patId (Long patId){
        this.patId=patId;
        return this;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
    public NoteDTO patient (String patient){
        this.patient=patient;
        return this;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public NoteDTO note (String note){
        this.note=note;
        return this;
    }
}

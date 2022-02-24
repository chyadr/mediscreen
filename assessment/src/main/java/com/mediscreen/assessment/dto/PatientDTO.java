package com.mediscreen.assessment.dto;

import java.time.ZonedDateTime;

public class PatientDTO {

    private Long id;
    private String family;
    private String given;
    private ZonedDateTime dob;
    private Gender sex;
    private String address;
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }
    public PatientDTO family (String family){
        this.family=family;
        return this;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }
    public PatientDTO given (String given){
        this.given=given;
        return this;
    }

    public ZonedDateTime getDob() {
        return dob;
    }

    public void setDob(ZonedDateTime dob) {
        this.dob = dob;
    }
    public PatientDTO dob (ZonedDateTime dob){
        this.dob=dob;
        return this;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }
    public PatientDTO sex (Gender sex){
        this.sex=sex;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public PatientDTO address (String address){
        this.address=address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public PatientDTO phoneNumber (String phoneNumber){
        this.phoneNumber=phoneNumber;
        return this;
    }
}

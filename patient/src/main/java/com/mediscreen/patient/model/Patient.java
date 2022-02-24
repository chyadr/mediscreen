package com.mediscreen.patient.model;




import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(generator = "seq_ids")
    @SequenceGenerator(name = "seq_ids", sequenceName = "seq_ids", allocationSize = 1)
    private Long id;

    @Column(name = "family")
    @NotBlank (message = "Only not blank values are accepted")
    private String family;
    @Column(name = "given")
    @NotBlank (message = "Only not blank values are accepted")
    private String given;
    @NotNull (message = "Only not null values are accepted")
    @PastOrPresent(message = "Only past or present date of birth accepted")
    @Column(name = "date_of_birth")
    private ZonedDateTime dob;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender sex;
    @Column(name = "address")
    @NotBlank (message = "Only not blank values are accepted")
    private String address;
    @NotBlank (message = "Only not blank values are accepted")
    //@Pattern(regexp="\\d{10}", message = "Only numbers accepted")
    @Column(name = "phone_number")
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
    public Patient family (String family){
        this.family=family;
        return this;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }
    public Patient given (String given){
        this.given=given;
        return this;
    }

    public ZonedDateTime getDob() {
        return dob;
    }

    public void setDob(ZonedDateTime dob) {
        this.dob = dob;
    }
    public Patient dob (ZonedDateTime dob){
        this.dob=dob;
        return this;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }
    public Patient sex (Gender sex){
            this.sex=sex;
            return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Patient address (String address){
        this.address=address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Patient phoneNumber (String phoneNumber){
        this.phoneNumber=phoneNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", family='" + family + '\'' +
                ", given='" + given + '\'' +
                ", dob=" + dob +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}


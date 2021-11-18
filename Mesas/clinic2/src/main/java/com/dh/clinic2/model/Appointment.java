package com.dh.clinic2.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Appointment {
    private Patient patient;
    private Dentist dentist;
    private Date date;

    public Appointment(Patient patient, Dentist dentist, Date date) {
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }
}

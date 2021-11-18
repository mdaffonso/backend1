package com.dh.clinic2.repository;

import com.dh.clinic2.model.Dentist;
import com.dh.clinic2.model.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointmentDAO {
    private Integer id;
    private Patient patient;
    private Dentist dentist;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;
}

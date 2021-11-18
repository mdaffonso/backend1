package com.dh.clinic2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {
    private String name;
    private String lastname;
    private String email;

    public Patient(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }
}

package com.dh.model;

import java.util.Date;

public class Person {
    private String name;
    private String surname;
    private String rg;
    private String vaccine;
    private Date vaccinationDate;

    public Person(String name, String surname, String rg, String vaccine, Date vaccinationDate) {
        this.name = name;
        this.surname = surname;
        this.rg = rg;
        this.vaccine = vaccine;
        this.vaccinationDate = vaccinationDate;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }
}

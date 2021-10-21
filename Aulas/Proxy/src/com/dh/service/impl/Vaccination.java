package com.dh.service.impl;

import com.dh.model.Person;

public class Vaccination {

    static VaccinationService service = new VaccinationService();
    static VaccinationProxy proxy = new VaccinationProxy(service);

    public static void apply(Person person) {
        proxy.vaccinate(person);
    }
}

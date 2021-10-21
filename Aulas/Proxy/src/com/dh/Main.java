package com.dh;

import com.dh.model.Person;
import com.dh.service.impl.Vaccination;
import com.dh.service.impl.VaccinationProxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("14/10/2021");
	    Person p = new Person("João", "das Couves", "123456789", "Pfizer", date);

        Vaccination.apply(p);
    }
}

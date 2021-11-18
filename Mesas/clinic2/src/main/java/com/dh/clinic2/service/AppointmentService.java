package com.dh.clinic2.service;

import com.dh.clinic2.model.Appointment;
import com.dh.clinic2.model.Dentist;
import com.dh.clinic2.model.Patient;
import com.dh.clinic2.repository.AppointmentDAO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AppointmentService {
    private static Map<String, Dentist> dentistMap = new HashMap<>();
    private static Map<String, Patient> patientMap = new HashMap<>();
    private static Map<Integer, Appointment> appointmentMap = new HashMap<>();
    private static Integer appointmentIndex = 0;

    public AppointmentService() {
        Patient[] patients = {
                new Patient("José", "das Couves", "jcouves@gmail.com"),
                new Patient("Valter", "Dias", "va.dias@hotmail.com"),
                new Patient("Vilmar", "Adonis", "vi.adonis@yahoo.com.br")
        };

        Dentist[] dentists = {
                new Dentist("Jonas", "Imaginarium", "jimagi@jimagi.de"),
                new Dentist("Nelson", "Xavier", "nelsinhoxavi@gmail.com"),
                new Dentist("Brandon", "Guido", "clinica.guido@gmail.com")
        };

        for (int i = 0; i < patients.length; i++) {
            patientMap.put(patients[i].getEmail(), patients[i]);
            dentistMap.put(dentists[i].getEmail(), dentists[i]);
        }
    }

    public Map<Integer, Appointment> all() {
        return appointmentMap;
    }

    public Appointment find(Integer id) {
        if(!appointmentMap.containsKey(id)) {
            return null;
        }
        Appointment a = appointmentMap.get(id);

        return a;
    }

    public Appointment create(AppointmentDAO a) {
        if (!dentistMap.containsKey(a.getDentist().getEmail()) || !patientMap.containsKey(a.getPatient().getEmail())) {
            return null;
        }
        appointmentIndex++;

        Appointment appointment = new Appointment(a.getPatient(), a.getDentist(), a.getDate());

        appointmentMap.put(appointmentIndex, appointment);
        return appointment;
    }

    public Appointment edit(Integer id, Appointment a) {
        if (!appointmentMap.containsKey(id)) {
            return null;
        }

        appointmentMap.put(id, a);
        return a;
    }

    public void delete(Integer id) {
        appointmentMap.remove(id);
    }

}

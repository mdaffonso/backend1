package com.dh.clinic.service;

import com.dh.clinic.dao.DentistDAO;
import com.dh.clinic.domain.Dentist;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DentistService {
    private Map<Integer, Dentist> dentistMap = new HashMap<>();
    private static Integer index = 0;

    public Map<Integer, Dentist> all() {
        return dentistMap;
    }

    public DentistDAO one(Integer id) {
        Dentist found = dentistMap.get(id);
        DentistDAO d = new DentistDAO();
        if (found == null) {
            return d;
        }
        d.setId(id);
        d.setName(found.getName());
        d.setCro(found.getCro());
        return d;
    }

    public DentistDAO create(DentistDAO d) {
        index++;
        Dentist dentist = new Dentist(d.getName(), d.getCro());
        dentistMap.put(index, dentist);
        d.setId(index);
        return d;
    }

    public DentistDAO edit(Integer id, Dentist d) {
        Dentist dentist = dentistMap.get(id);
        if(dentist == null) {
            return new DentistDAO();
        }
        dentistMap.put(id, d);
        DentistDAO dao = new DentistDAO();
        dao.setName(d.getName());
        dao.setCro(d.getCro());
        dao.setId(id);
        return dao;
    }

    public void delete(Integer id) {
        dentistMap.remove(id);
    }
}

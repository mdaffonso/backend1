package com.dh.server;


import com.dh.model.Dentist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H2ServerTest {

    private static H2Server server;
    private static List<Dentist> dentists = new ArrayList<>();

    @BeforeAll
    public static void connect() {
        server = new H2Server();
        Collections.addAll(dentists,
                new Dentist("Matheus", "Affonso", "0123456"),
                new Dentist("Josias", "Xablankton", "0987654"));
    }

    @Test
    public void create() {
        Dentist inserted;

        inserted = server.insert(dentists.get(1));
        server.insert(dentists.get(0));

        Assertions.assertNotNull(inserted.getId());
        Assertions.assertNotNull(inserted.getMatricula());
        Assertions.assertNotNull(inserted.getNome());
        Assertions.assertNotNull(inserted.getSobrenome());
    }

    @Test
    public void findById() {
        Dentist found = server.findById(1);
        Assertions.assertEquals(1, found.getId());
        Assertions.assertNotNull(found.getNome());
        Assertions.assertNotNull(found.getSobrenome());
        Assertions.assertNotNull(found.getMatricula());
    }

    @Test
    public void findAll() throws Exception {
        List<Dentist> all = server.findAll();
        Assertions.assertNotNull(all.get(0));
    }
}

package com.dh.server;

import com.dh.config.ConfigJDBC;
import com.dh.model.Dentist;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class H2Server implements IDAO<Dentist> {

    private Logger logger;
    private Connection connection;

    public H2Server() {
        logger = Logger.getLogger(H2Server.class);
        PropertyConfigurator.configure("log4j.properties");

        try {
            connection = ConfigJDBC.getH2();
            setup();
        } catch (Exception e) {
            logger.fatal(e.getMessage());
        }
    }

    private void setup() {
        List<String> tables = new ArrayList<>();
        Collections.addAll(tables,
                "DROP TABLE IF EXISTS dentista;",

                "CREATE TABLE IF NOT EXISTS dentista (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, matricula VARCHAR(100) NOT NULL UNIQUE, "
                        + "nome VARCHAR (50) NOT NULL, "
                        + "sobrenome VARCHAR (100) NOT NULL);"
                );

        for (String table : tables) {
            try {
                Statement stmt = connection.createStatement();
                stmt.execute(table);
                logger.debug("Conectado ao banco de dados H2");
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Override
    public Dentist insert(Dentist dentist) {
        Dentist generatedDentist = new Dentist();

        try {
            String query = "INSERT INTO dentista (matricula, nome, sobrenome) VALUES (?, ?, ?);";

            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, dentist.getMatricula());
            stmt.setString(2, dentist.getNome());
            stmt.setString(3, dentist.getSobrenome());
            stmt.execute();

            ResultSet result = stmt.getGeneratedKeys();
            if (result.next()) {
                generatedDentist.setId(result.getInt("id"));
                generatedDentist.setMatricula(dentist.getMatricula());
                generatedDentist.setNome(dentist.getNome());
                generatedDentist.setSobrenome(dentist.getSobrenome());
            }
            logger.debug("Objeto inserido no banco de dados: " + generatedDentist.toString());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return generatedDentist;
    }

    @Override
    public Dentist update(Dentist dentist) {

        return null;
    }

    @Override
    public Dentist findById(int id) {
        Dentist found = new Dentist();

        try {
            String query = "SELECT * FROM dentista WHERE id = ?;";

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();

            ResultSet result = stmt.getResultSet();
            if(result.next()) {
                found.setId(result.getInt("id"));
                found.setMatricula(result.getString("matricula"));
                found.setNome(result.getString("nome"));
                found.setSobrenome(result.getString("sobrenome"));
            }
            logger.debug("Busca realizada com sucesso no banco de dados. Encontrou:\n" + found.toString());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return found;
    }

    @Override
    public List<Dentist> findAll() throws Exception {
        List<Dentist> results = new ArrayList<>();

        try {
            String query = "SELECT * FROM dentista;";

            Statement stmt = connection.createStatement();
            stmt.execute(query);

            ResultSet result = stmt.getResultSet();
            String resultString = "";
            while(result.next()) {
                Dentist d = new Dentist();
                d.setId(result.getInt("id"));
                d.setMatricula(result.getString("matricula"));
                d.setNome(result.getString("nome"));
                d.setSobrenome(result.getString("sobrenome"));

                results.add(d);

                resultString += d.toString() + "\n";
            }

            logger.debug("Busca realizada no banco de dados com sucesso. Retornou os seguintes resultados: \n" + resultString);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


        return results;
    }

    @Override
    public void delete(int id) {

    }
}

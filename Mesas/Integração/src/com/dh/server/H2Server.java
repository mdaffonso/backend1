package com.dh.server;

import com.dh.config.ConfigJDBC;
import com.dh.model.Address;
import com.dh.model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H2Server implements IDAO<Patient> {

    Connection connection;

    public H2Server() {
        try {
            connection = ConfigJDBC.getH2();
            setup();
        } catch (Exception e) {
            System.out.println("Não foi possível conectar-se ao banco de dados...");
        }
    }

    private void setup() throws SQLException {
        List<String> tables = new ArrayList<>();
        Collections.addAll(tables,
                "DROP TABLE IF EXISTS endereco;",

                "CREATE TABLE IF NOT EXISTS estado (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, estado CHAR(2) NOT NULL);",

                "INSERT INTO estado (estado) VALUES "
                        + "('AC'), "
                        + "('AL'), "
                        + "('AM'), "
                        + "('BA'), "
                        + "('CE'), "
                        + "('DF'), "
                        + "('ES'), "
                        + "('GO'), "
                        + "('MA'), "
                        + "('MT'), "
                        + "('MS'), "
                        + "('MG'), "
                        + "('PA'), "
                        + "('PB'), "
                        + "('PR'), "
                        + "('PE'), "
                        + "('PI'), "
                        + "('RJ'), "
                        + "('RN'), "
                        + "('RS'), "
                        + "('RO'), "
                        + "('RR'), "
                        + "('SC'), "
                        + "('SP'), "
                        + "('SE'), "
                        + "('TO');",

                "CREATE TABLE IF NOT EXISTS endereco (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, logradouro VARCHAR(100) NOT NULL, "
                        + "numero VARCHAR(5) NOT NULL, complemento VARCHAR(100), cidade VARCHAR(100) NOT NULL, "
                        + "estado_id INT, "
                        + "CONSTRAINT fk_estado FOREIGN KEY (estado_id) REFERENCES estado(id));",

                "CREATE TABLE IF NOT EXISTS paciente (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(100) NOT NULL, "
                        + "sobrenome VARCHAR(100) NOT NULL, rg VARCHAR(100) NOT NULL, dataCadastro DATE DEFAULT CURRENT_TIMESTAMP(), endereco_id INT, "
                        + "CONSTRAINT fk_endereco FOREIGN KEY (endereco_id) REFERENCES endereco(id));"
                );

        for (String table : tables) {
            Statement stmt = connection.createStatement();
            stmt.execute(table);
        }
    }

    @Override
    public Patient insert(Patient patient) throws SQLException {

        Address endereco = patient.getEndereco();

        String addressQuery = "INSERT INTO endereco (logradouro, numero, complemento, cidade, estado_id) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(addressQuery, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, endereco.getLogradouro());
        stmt.setString(2, endereco.getNumero());
        stmt.setString(3, endereco.getComplemento());
        stmt.setString(4, endereco.getCidade());
        stmt.setString(5, endereco.getEstado().toString());
        stmt.execute();

        return patient;
    }

    @Override
    public Patient update(Patient patient) {
        return null;
    }

    @Override
    public Patient findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}

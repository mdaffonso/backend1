package com.dh.model;

import java.sql.*;

public class DrugH2DAO {
    Connection connection;

    DrugH2DAO() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        this.connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }

    public void save(Drug drug) throws SQLException {
        String executeQuery;
        PreparedStatement executeStmt;

        String query = "SELECT * FROM drug WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, drug.getId());
        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            executeQuery = "UPDATE drug SET name = ?, laboratory = ?, number_code = ?, quantity = ?, price = ? where id = ?";
        } else {
            executeQuery = "INSERT INTO drug (name, laboratory, number_code, quantity, price, id) VALUES (?, ?, ?, ?, ?, ?)";
        }

        executeStmt = connection.prepareStatement(executeQuery);
        executeStmt.execute();
    }
}

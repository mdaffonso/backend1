package com.dh;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Connection connection;
        List<String> statements = new ArrayList<>();
        Collections.addAll(statements,
                "drop table if exists employee;",
                "create table if not exists employee (id int primary key, name varchar(150) not null, email varchar(150) not null, favorite_color varchar(40), hobbies text);",
                "insert into employee (id, name, email, favorite_color, hobbies) values ('1', 'Paulo Paulada Power', 'pppower@hotmail.com', 'vermelho', 'correr atrás de carros');",
                "insert into employee (id, name, email, favorite_color, hobbies) values ('1', 'Jonas Imaginarium', 'jimagi@gmail.com', 'azul', 'jogos de pc, tocar bateria, salto em vara');",
                "insert into employee (id, name, email, favorite_color, hobbies) values ('2', 'Lerolero Abdul', 'leroleroabdul@uol.com.br', null, null);",
                "update employee set name = 'Xablauson Xavier' where id = '1';",
                "delete from employee where name = 'Lerolero Abdul';"
        );

        try {
            connection = getConnection();
            Statement s = connection.createStatement();
            ResultSet rs = null;

            for (String statement : statements) {
                try {
                    Pattern pInsert = Pattern.compile(".+values \\('(\\d+)',.+");
                    Pattern pUpdate = Pattern.compile("update.+where id.+'(\\d)'.+");
                    Pattern pDelete = Pattern.compile("delete.+where (.+) = '(.+)'.+");
                    Matcher matcher = pInsert.matcher(statement).matches()
                            ? pInsert.matcher(statement)
                            : pUpdate.matcher(statement);

                    Matcher delMatcher = pDelete.matcher(statement);

                    if (delMatcher.matches()) {
                        rs = connection.createStatement().executeQuery("select * from employee where " + delMatcher.group(1) + " = '" + delMatcher.group(2) + "';");
                    }

                    s.execute(statement);

                    if (matcher.matches()) {
                        rs = connection.createStatement().executeQuery("select * from employee where id = '" + matcher.group(1) + "';");
                    }

                    if (rs != null) {
                        while(rs.next()) {
                            String display = "Id: " + rs.getString("id") +
                                    " | Nome: " + rs.getString("name") +
                                    " | E-mail: " + rs.getString("email") +
                                    " | Cor favorita: " + rs.getString("favorite_color") +
                                    " | Hobbies: " + rs.getString("hobbies");
                            logger.debug(display);
                        }
                    }

                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }

        } catch (Exception e) {
            logger.fatal("Não foi possível conectar ao banco de dados...");
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}

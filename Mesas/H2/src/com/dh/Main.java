package com.dh;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
	    Connection connection;
	    try {
	        connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("create table if not exists polygon (" +
                    "id int primary key auto_increment, " +
                    "type varchar(120) not null, " +
                    "color varchar(40) not null" +
                    ")"
            );

            if (!statement.executeQuery("select * from polygon;").next()) {
                statement.execute("insert into polygon (type, color) values " +
                        "('circle', 'red'), " +
                        "('circle', 'blue'), " +
                        "('square', 'yellow'), " +
                        "('square', 'magenta'), " +
                        "('square', 'cyan'), " +
                        "('square', 'red');"
                );
            }

            ResultSet query = statement.executeQuery("select id, type, color from polygon where color = 'red' and type = 'circle';");

            while (query.next()) {
                String type = query.getString("type");
                String color = query.getString("color");
                int id = query.getInt("id");

                System.out.println("Id:      " + id);
                System.out.println("Type:    " + type);
                System.out.println("Color:   " + color + "\n");
            }


        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}

package org.example.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Util {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String jdbcUrl = "jdbc:postgresql://localhost:5432/TaskJDBC_db";
        String user = "myUser";
        String password = "myUser";

        return DriverManager.getConnection(jdbcUrl, user, password);
    }
}

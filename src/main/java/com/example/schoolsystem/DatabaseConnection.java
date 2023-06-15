package com.example.schoolsystem;

import java.sql.*;

import static com.example.schoolsystem.Constants.PASS;
import static java.lang.Class.forName;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() throws SQLException {
        String databaseName = "Login";
        String databaseUser = "root";
        String databasePassword = PASS;
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
            return databaseLink;
        }
    }


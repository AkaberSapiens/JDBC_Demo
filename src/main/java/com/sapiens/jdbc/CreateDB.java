package com.sapiens.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Established the Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
        System.out.println("connection Established successfully");

        Statement statement = connection.createStatement();
        String sql = "CREATE DATABASE EMP";
        statement.executeUpdate(sql);
        System.out.println("DB created successfully");
    }

}


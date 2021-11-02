package com.sapiens.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Established the Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
        System.out.println("connection Established successfully to emp DB");


        String sql = "CREATE TABLE EmployeeDetails(ID INT NOT NULL AUTO_INCREMENT," +
                "NAME VARCHAR(20),AGE INT,DEPT VARCHAR(20),DESIG VARCHAR(20),QUALIFICATION VARCHAR(20)," +
                "EMAIL_ID VARCHAR(50),CONTACT VARCHAR(20),SALARY DECIMAL(6.2),TOTAL_YEARS_OF_EXP INT,PRIMARY KEY (ID))    ";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println("EmployeeDetails table created successfully ");

        String sql1 = "CREATE TABLE MANGERS(ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(20),PRIMARY KEY (ID))";
        Statement statement1 = connection.createStatement();
        statement1.executeUpdate(sql1);
        System.out.println("MANGERS table created successfully ");

        String sql2 = "CREATE TABLE Clients(ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(20),PRIMARY KEY (ID))";
        Statement statement2 = connection.createStatement();
        statement2.executeUpdate(sql2);
        System.out.println("Clients table created successfully ");
    }
}

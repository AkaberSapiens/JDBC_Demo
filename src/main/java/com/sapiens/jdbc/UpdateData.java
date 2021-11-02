package com.sapiens.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new name: "); String new_name = scanner.next();
        System.out.println("Enter ID : "); String ID = scanner.next();


        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Established the Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");
        System.out.println("connection Established successfully to emp DB");
        Statement statement = connection.createStatement();
        String sql = "UPDATE EmployeeDetails SET NAME = '"+new_name+"' WHERE ID ="+ID+"";
        int result = statement.executeUpdate(sql);
        System.out.println("Table updated successfully..");
        connection.close();
    }
}

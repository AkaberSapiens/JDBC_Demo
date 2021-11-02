package com.sapiens.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: "); String id = scanner.next();
        System.out.println("Enter NAME: "); String name = scanner.next();
        System.out.println("Enter AGE: "); String age = scanner.next();
        System.out.println("Enter DEPT: "); String dept = scanner.next();
        System.out.println("Enter DESIG: "); String desig = scanner.next();
        System.out.println("Enter QUALIFICATION: "); String qualification = scanner.next();
        System.out.println("Enter EMAIL_ID: "); String email = scanner.next();
        System.out.println("Enter CONTACT: "); String contact = scanner.next();
        System.out.println("Enter SALARY: "); String salary = scanner.next();
        System.out.println("Enter TOTAL_YEARS_OF_EXP: "); String total_years_of_exp = scanner.next();



        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Established the Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");
        System.out.println("connection Established successfully to emp DB");
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO EmployeeDetails VALUES("+id+",'"+name+"',"+age+",'"+dept+"','"+desig+"','"+qualification+"','"+email+"','"+contact+"',"+salary+","+total_years_of_exp+")";
        int result = statement.executeUpdate(sql);
        if(result==1){
            System.out.println("Transaction is successful"+sql);
        }else{
            System.out.println("Transaction Failed");
        }
        System.out.println("Table updated successfully..");
        connection.close();
    }
}

package com.sapiens.jdbc;

import java.sql.*;
import java.util.Scanner;

public class CrudSwitch {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Established the Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");
        System.out.println("connection Established successfully to emp DB");
        Statement statement = connection.createStatement();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number from 1-4 \n 1.insert data to the table. \n" +
                "\2.update a table. \n 3.delete from the table. \n 4. view from table ");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                System.out.println("Enter ID: ");
                int id1 = scanner.nextInt();
                System.out.println("Enter name: ");
                String name = scanner.next();
                String sql1 = "INSERT INTO clients VALUES("+id1+",'"+name+"')";
                int result = statement.executeUpdate(sql1);
                if(result==1){
                    System.out.println("Transaction is successful"+sql1);
                }else{
                    System.out.println("Transaction Failed");
                }
                System.out.println("Table updated successfully..");
                connection.close();
                break;
            case 2:
                System.out.println("Enter the new name: ");
                String new_name = scanner.next();
                System.out.println("Enter ID : ");
                int id2 = scanner.nextInt();
                String sql2 = "UPDATE clients SET NAME = '"+new_name+"' WHERE ID ="+id2+"";
                statement.executeUpdate(sql2);
                System.out.println("Table updated successfully..");
                connection.close();
                break;
            case 3:
                System.out.println("Enter the ID of the client that you want to delete: ");
                int id3 = scanner.nextInt();
                String sql3 = "DELETE from clients WHERE ID="+id3+"";
                statement.executeUpdate(sql3);
                System.out.println("Table updated successfully..");
                connection.close();
                break;

            case 4:
                String sql4 = "SELECT * FROM clients";
                ResultSet resultSet = statement.executeQuery(sql4);
                System.out.println("Clients details");
                while (resultSet.next()){
                    System.out.println("ID: "+resultSet.getString("ID"));
                    System.out.println("Name: "+resultSet.getString("NAME"));

                }
                break;
            default:
                System.out.println("choose a number from 1 to 4");
        }
    }
}

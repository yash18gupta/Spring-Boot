package com.geeksforgeeks;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql:///jdbl60";
        String username = "root";
        String password = "yash";

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Object is created");

            Statement statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);
            int choice;

            while(true){
                System.out.println("Choose an option");
                System.out.println("1. Insert");
                System.out.println("2. Select");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.println("Enter your choice");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1: //INSERT
                        System.out.println("Enter student name: ");
                        String name = scanner.nextLine();

                        System.out.println("Enter student age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter student address: ");
                        String address = scanner.nextLine();

                        String sqlInsert = "INSERT INTO STUDENT(SNAME,SAGE,SADDRESS) VALUES(?,?,?)";

                        PreparedStatement insertStatement = connection.prepareStatement(sqlInsert);

                        insertStatement.setString(1,name);
                        insertStatement.setInt(2,age);
                        insertStatement.setString(3,address);

                        int rowsInserted = insertStatement.executeUpdate();

                        if(rowsInserted>0){
                            System.out.println("Your data is inserted");
                        }
                        else{
                            System.out.println("Not inserted");
                        }
                        break;

                    case 2:
                        String sqlSelectQuery = "SELECT SID,SADDRESS,SAGE,SNAME FROM STUDENT";
                        ResultSet resultSet = statement.executeQuery(sqlSelectQuery);

                        while(resultSet.next()){
                            Integer id = resultSet.getInt(1);
                            String selectedAddress = resultSet.getString(2);
                            int selectedAge = resultSet.getInt(3);
                            String selectedName = resultSet.getString(4);

                            System.out.println(id + "\t"+ selectedAddress + "\t" + selectedAge + "\t" + selectedName);
                        }
                        break;

                    case 3: //update
                        System.out.println("Enter student sid to be updated: ");
                        int studentIdUpdate = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.println("Enter new age: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter new address: ");
                        String newAddress = scanner.nextLine();

                        String sqlUpdate = "UPDATE STUDENT SET SNAME=?,SAGE=?,SADDRESS=? WHERE SID=?";

                        PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate);

                        updateStatement.setString(1,newName);
                        updateStatement.setInt(2,newAge);
                        updateStatement.setString(3,newAddress);
                        updateStatement.setInt(4,studentIdUpdate);

                        int rowUpdated = updateStatement.executeUpdate();

                        if(rowUpdated>0){
                            System.out.println("Your data is updated");
                        }
                        else{
                            System.out.println("Not updated!");
                        }
                        break;

                    case 4:
                        System.out.println("Enter sid of student to be deleted: ");
                        int studentIdDelete = scanner.nextInt();
                        scanner.nextLine();

                        String sqlDelete = "DELETE FROM STUDENT WHERE SID=?";

                        PreparedStatement deleteStatement = connection.prepareStatement(sqlDelete);

                        deleteStatement.setInt(1,studentIdDelete);

                        int rowDeleted = deleteStatement.executeUpdate();

                        if(rowDeleted>0){
                            System.out.println("Your data is deleted");
                        }
                        else{
                            System.out.println("Data not deleted!");
                        }
                        break;

                    case 5:
                        connection.close();
                        System.out.println("Successfully exit");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
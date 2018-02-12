package org.softuni.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    public static Connection conn = null;

    private MyConnection(){}

    public static Connection getConnection(){

        if(conn == null){
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());

                String URL = "jdbc:mysql://localhost:3306/servlets?createDatabaseIfNotExists=true";
                String USERNAME = "root";
                String PASSWORD = "1234";

                return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }catch (SQLException e){
                e.printStackTrace();
                return null;
            }
        }

        return conn;
    }


}

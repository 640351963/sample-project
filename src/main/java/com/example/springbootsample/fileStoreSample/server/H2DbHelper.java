package com.example.springbootsample.fileStoreSample.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DbHelper {

    private static Connection connection;

    static {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createConnection() throws SQLException {
        if (connection.isClosed()) {
            connection = DriverManager.getConnection("");
        }
    }

    public static void  createTable() throws SQLException {
        try{
            createConnection();
            Statement statement = connection.createStatement();
            String sql = "";
            int i = statement.executeUpdate(sql);

        }catch (Exception e){

        }
    }
}

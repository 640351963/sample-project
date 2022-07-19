package com.example.springbootsample.hsql;

import java.sql.*;

public class HsqlSample {


    public static void main(String[] args) {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection c = DriverManager.getConnection("jdbc:hsqldb:file:d:/db/testdb", "SA", "");
            System.out.println(c.getAutoCommit());
            final PreparedStatement preparedStatement1 = c.prepareStatement("CREATE TABLE t(a INTEGER, b BIGINT);");
            final boolean execute = preparedStatement1.execute();
            System.out.println(execute);
////            final PreparedStatement preparedStatement = c.prepareStatement("select 1");
//
//            final ResultSet resultSet = preparedStatement.getResultSet();
//            if(resultSet.next()){
//                final int row = resultSet.getRow();
//                System.out.println(row);
//            }
//            resultSet.close();
            preparedStatement1.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

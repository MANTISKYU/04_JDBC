package com.ohgiraffers.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate2 {

    // 커넥션을 리턴해주는 메소드

    public static Connection getConnection () {

        Connection con2 = null;

        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info2.properties"));


            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/ogclass",
                    "ohgiraffers", "ohgiraffers");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return con2;

    }

    public static void close(Connection con2) {

        try {
            if (con2 != null && !con2.isClosed()) {
                con2.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void close(ResultSet rset2) {

        try {
            if (rset2 != null && !rset2.isClosed()) {
                rset2.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void close(Statement stmt2) {

        try {
            if (stmt2 != null && !stmt2.isClosed()) {
                stmt2.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}

package com.ofgiraffers.section01.connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application3 {

    public static void main(String[] args) {


        Properties prop = new Properties();


        // DB접속을 위한 connection 객체
        // 생성하기 위해 레퍼런스 변수로 선언
        // 데이터베이스 종류, 계정 정보
        Connection con = null;


        // 사용할 드라이버 등록
        try {

            prop.load(new FileReader("src/main/java/com/ofgiraffers/section01/connection/jdbc-config.properties"));

            System.out.println("prop =" + prop);

            // Key-value로 원하는 값 찾아오기
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/menudb", "ohgiraffers", "ohgiraffers");

            System.out.println("con =" + con);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
       } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(con != null) {

                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}

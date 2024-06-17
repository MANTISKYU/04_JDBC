package com.ofgiraffers.section02.template;

import java.sql.Connection;
import java.sql.SQLException;

import static com.ofgiraffers.section02.template.JDBCTemplate.close;
import static com.ofgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {


        // 데이터베이스와 연결하는 연결 객체
        Connection con = getConnection();

        // 연결객체 생성되었는지 확인. (객체의 주소값이 반환되었는지 확인)
        System.out.println("con =" + con);

//        try {
//            con.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        close(con);

    }

}

package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application3 {

    public static void main(String[] args) {

        // 1. Connection 객체 생성
        Connection con = getConnection();

        // 2. Statement 생성
        Statement stmt = null;

        // 3. ResultSet 생성
        ResultSet rset = null;

        try {
            // 4. 연결객체의 createStatement()를 이용한 Statement 객체 생성
            stmt = con.createStatement();

            // 스캐너로 emp_id를 입력받아 조회하기
            Scanner sc = new Scanner(System.in);
            System.out.println("조회하려는 사번을 입력하세요 : ");
            String empId = sc.nextLine();

            rset = stmt.executeQuery("select emp_id, emp_name from employee where emp_id = '" + empId + "'");

            String query = "select emp_id, emp_name from employee where emp_id = '" + empId + "'";
            rset = stmt.executeQuery(query);

            // 6. 쿼리문의 결과를 컬럼 이름을 이용해서 사용
            if(rset.next()) {

                System.out.println(rset.getString("emp_id") + ", " + rset.getString("emp_name"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

           close(rset);
           close(stmt);
           close(con);

        }


    }

}

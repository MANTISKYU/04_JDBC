package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {

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


            String empId = "200";
            rset = stmt.executeQuery("select emp_id, emp_name from employee where emp_id = '" + empId + "'");

            String query = "select emp_id, emp_name from employee where emp_id = '" + empId + "'";

            //5. 쿼리문을 실행하고 결과를 Resultset에 반환 받기
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

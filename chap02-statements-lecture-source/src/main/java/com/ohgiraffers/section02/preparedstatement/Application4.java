package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.DepartmentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application4 {

    public static void main(String[] args) {


        /*
        * Department 테이블의 부서코드(아이디)를 입력받아서
        * 부서코드(아이디), 부서명, 지역코드를 출력하시오
        *
        * */

        Connection con2 = getConnection();

        PreparedStatement pstmt2 = null;

        ResultSet rset2 = null;

        DepartmentDTO selectedDep = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("조회할 사번을 입력해주세요");

        String deptId = sc.nextLine();

        String query2 = " select * from Department where dept_id = ? ";


        try {
            pstmt2 = con2.prepareStatement(query2);

            pstmt2.setString(1, deptId);

            rset2 = pstmt2.executeQuery();

            if(rset2.next()) {

                selectedDep = new DepartmentDTO();

                selectedDep.setDept_id(rset2.getString("DEPT_ID"));
                selectedDep.setDept_title(rset2.getString("DEPT_TITLE"));
                selectedDep.setLocation_id(rset2.getString("LOCATION_ID"));


            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            close(rset2);
            close(pstmt2);
            close(con2);


        }

        System.out.println("selectedDep = " + selectedDep);


    }

}

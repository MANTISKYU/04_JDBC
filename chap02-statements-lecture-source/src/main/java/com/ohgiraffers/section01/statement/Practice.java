package com.ohgiraffers.section01.statement;

import com.ohgiraffers.model.dto.ClassDTO;
import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.ohgiraffers.common.JDBCTemplate2.close;
import static com.ohgiraffers.common.JDBCTemplate2.getConnection;

public class Practice {

    public static void main(String[] args) {

        Connection con2 = getConnection();

        Statement stmt2 = null;

        ResultSet rset2 = null;

        ClassDTO row2 = null;

        List<ClassDTO> empList2 = null;



        try {

            empList2 = new ArrayList<>();

            stmt2 = con2.createStatement();

            rset2 = stmt2.executeQuery("select * from class ");

            while(rset2.next()) {

                row2 = new ClassDTO();

                row2.setStudent_no(rset2.getInt("student_no"));
                row2.setStudent_name(rset2.getString("student_name"));
                row2.setGender(rset2.getString("gender"));
                row2.setGithub_id(rset2.getString("github_id"));
                row2.setMbti(rset2.getString("mbti"));
                row2.setSubject_no(rset2.getInt("subject_no"));


                empList2.add(row2);

                // .next() : resultset의 커서 위치를 하나 내리면서 행이 존재하면 true, 아니면 false

//                System.out.println(rset2.getString("student_no") + ", " + rset2.getString("student_name"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            close(rset2);
            close(stmt2);
            close(con2);

        }
        for(ClassDTO cd: empList2 ) {

            System.out.println(cd);

        }


    }

}

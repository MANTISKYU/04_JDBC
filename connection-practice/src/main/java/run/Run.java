package run;

import model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

public class Run {

    public static void main(String[] args) {


        Connection con = getConnection();

        int result = 0;

        Properties prop = new Properties();
        PreparedStatement pstmt = null;
//        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("변경할 근로자코드는 몇 번입니까");
        String empId = sc.nextLine();

        System.out.println("변경할 이름이 뭡니까");
        String empName = sc.nextLine();

        EmployeeDTO changedEmployee = new EmployeeDTO();
        changedEmployee.setEmpId(empId);
        changedEmployee.setEmpName(empName);

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/mapper/employee-query.xml"));

            String query = prop.getProperty("updateEmployee");
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, changedEmployee.getEmpId());
            pstmt.setString(2, changedEmployee.getEmpName());
            pstmt.setString(3, changedEmployee.get());
            pstmt.setString(4, changedEmployee.getEmpName());
            pstmt.setString(5, changedEmployee.getEmpName());
            pstmt.setString(6, changedEmployee.getEmpName());
            pstmt.setString(7, changedEmployee.getEmpName());
            pstmt.setString(8, changedEmployee.getEmpName());
            pstmt.setString(9, changedEmployee.getEmpName());
            pstmt.setString(10, changedEmployee.getEmpName());
            pstmt.setString(11, changedEmployee.getEmpName());
            pstmt.setString(12, changedEmployee.getEmpName());
            pstmt.setString(13, changedEmployee.getEmpName());
            pstmt.setString(14, changedEmployee.getEmpName());


//            rset = pstmt.executeQuery("select * from employee");

//            Scanner sc = new Scanner(System.in);
//
//            System.out.println("변경할 근로자코드는 몇 번입니까");
//            String empId = sc.nextLine();
//
//            System.out.println("변경할 이름이 뭡니까");
//            String empName = sc.nextLine();

//            System.out.println("주민번호는 몇번입니까");
//            String empNO = sc.nextLine();
//
//            System.out.println("이메일주소가 어떻게 됩니까");
//            String email = sc.nextLine();
//
//            System.out.println("전화번호가 몇 번입니까");
//            int phone = sc.nextInt();
//
//            System.out.println("부서코드가 뭡니까");
//            String deptCode = sc.nextLine();
//
//            System.out.println("직업코드가 뭡니까");
//            String jobCode = sc.nextLine();
//
//            System.out.println("연봉레벨이 몇입니까");
//            String salLevel = sc.nextLine();
//
//            System.out.println("연봉이 몇입니까");
//            int salary = sc.nextInt();
//
//            System.out.println("보너스가 몇입니까");
//            double bonus = sc.nextDouble();
//
//            System.out.println("관리자 아이디가 뭡니까");
//            String managerId = sc.nextLine();
//
//            System.out.println("입사날짜가 언젭니까");
//            DateTimeFormatter hireDate = DateTimeFormatter.ofPattern(sc.next());
//
//            System.out.println("퇴사날짜가 언젭니까");
//            DateTimeFormatter entDate = DateTimeFormatter.ofPattern(sc.nextLine());
//
//            System.out.println("현재 재직중인가요");
//            String entYn = sc.nextLine().toUpperCase();

//            pstmt.setString(1, getEmpId);




            result = pstmt.executeUpdate();

//            while(rset.next()) {
//
//                // .next() : resultset의 커서 위치를 하나 내리면서 행이 존재하면 true, 아니면 false
//
//                System.out.println(rset.getString("emp_id") + ", " + rset.getString("emp_name"));
//
//            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

//            close(rset);
            close(pstmt);
            close(con);


        }

        if(result > 0) {
            System.out.println("사람 저장 성공");

        } else {

            System.out.println("사람 저장 실패");
        }


    }

}

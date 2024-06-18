package run;

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
        ResultSet rset = null;

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/mapper/employee-query.xml"));

            String query = prop.getProperty("insertEmployee");
            pstmt = con.prepareStatement(query);
//            rset = pstmt.executeQuery("select * from employee");

            Scanner sc = new Scanner(System.in);

            System.out.println("근로자코드는 몇 번입니까");
            String empId = sc.nextLine();

            System.out.println("이름이 뭡니까");
            String empName = sc.nextLine();

            System.out.println("주민번호는 몇번입니까");
            int empNO = sc.nextInt();

            System.out.println("이메일주소가 어떻게 됩니까");
            String email = sc.nextLine();

            System.out.println("전화번호가 몇 번입니까");
            int phone = sc.nextInt();

            System.out.println("부서코드가 뭡니까");
            String deptCode = sc.nextLine();

            System.out.println("직업코드가 뭡니까");
            String jobCode = sc.nextLine();

            System.out.println("연봉레벨이 몇입니까");
            String salLevel = sc.nextLine();

            System.out.println("연봉이 몇입니까");
            int salary = sc.nextInt();

            System.out.println("보너스가 몇입니까");
            int bonus = sc.nextInt();

            System.out.println("관리자 아이디가 뭡니까");
            String managerId = sc.nextLine();

            System.out.println("입사날짜가 언젭니까");
            DateTimeFormatter hireDate = DateTimeFormatter.ofPattern(sc.next());

            System.out.println("퇴사날짜가 언젭니까");
            DateTimeFormatter entDate = DateTimeFormatter.ofPattern(sc.nextLine());

            System.out.println("현재 재직중인가요");
            String entYn = sc.nextLine().toUpperCase();




            result = pstmt.executeUpdate();



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

//            close(rset);
            close(pstmt);
            close(con);


        }


    }

}

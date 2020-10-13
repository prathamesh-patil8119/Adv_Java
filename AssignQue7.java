package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AssignQue7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","cdac");
			
			System.out.println("Enter Roll no : ");
			int rollno = sc.nextInt();
			
			PreparedStatement s = conn.prepareStatement("select * from student where rno = "+rollno);
			
			ResultSet rs = s.executeQuery();
			
			while(rs.next()) {
				System.out.println("Roll No : "+rs.getInt(1)
				+": Name : "+rs.getString(2)
				+": Marks : "+rs.getDouble(3)
				+": DOB : "+rs.getString(4)
				);
			}
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

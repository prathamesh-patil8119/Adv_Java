package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AssignQue_2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id :");
		int id = sc.nextInt();
		System.out.println("Enter name :");
		String name = sc.next();
		System.out.println("Enter Marks :");
		double marks = sc.nextDouble();
		System.out.println("Enter DOB :");
		String dob = sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","cdac");
			
			PreparedStatement s = conn.prepareStatement("insert into student values(?,?,?,?)");
			
			s.setInt(1, id);
			s.setString(2, name);
			s.setDouble(3, marks);
			s.setString(4, dob);
			
			int i = s.executeUpdate();
			System.out.println(i+" Rows added");
			
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

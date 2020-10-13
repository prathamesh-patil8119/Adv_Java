package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AssignQue3 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","cdac");
			
			PreparedStatement s = conn.prepareStatement("select * from student");
			
			ResultSet rs =  s.executeQuery();
			
			while(rs.next()) {
				System.out.println("Roll No : "+rs.getInt(1)
									+": Name : "+rs.getString(2)
									+": Marks : "+rs.getDouble(3)
									+": DOB : "+rs.getString(4)
									);
			}
			
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

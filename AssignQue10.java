package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AssignQue10 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","cdac");
			
			PreparedStatement s = conn.prepareStatement("select * from student");
			
			ResultSet rs = s.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("No of columns in a table : "+rsmd.getColumnCount());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AssignQue2 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","cdac");
			
			PreparedStatement s = conn.prepareStatement("insert into student values(?,?,?,?)");
			
			s.setInt(1, 1);
			s.setString(2, "Prathya");
			s.setInt(3, 89);
			s.setString(4, "1996-07-03");
						
			s.execute();
			
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

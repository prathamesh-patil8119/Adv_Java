package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AssignQue1 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/advjava","root","cdac");
			
			Statement s = conn.createStatement();
			
			s.execute("create table student(rno int(20) primary key, name varchar(30), marks float(20), dob date)");
			
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

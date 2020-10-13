package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AssignQue6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to show all table values : ");
		
		System.out.println("Enter 2 to insert values in table : ");
		
		System.out.println("Enter 3 to delete values from table : ");
		
		System.out.println("Enter 4 to update values from table : ");
		int choice = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","cdac");
			
			switch (choice) {
			case 1:
				
				Statement s1 = conn.createStatement();
				
				String str1 = "select * from student";
				
				ResultSet rs = s1.executeQuery(str1);
				
				while(rs.next()) {
					System.out.println("Roll No : "+rs.getInt(1)
					+": Name : "+rs.getString(2)
					+": Marks : "+rs.getDouble(3)
					+": DOB : "+rs.getString(4)
					);
				}
				
				conn.close();
				
				break;
				
			case 2:
				
				System.out.println("Enter Id :");
				int id = sc.nextInt();
				System.out.println("Enter name :");
				String name = sc.next();
				System.out.println("Enter Marks :");
				double marks = sc.nextDouble();
				System.out.println("Enter DOB :");
				String dob = sc.next();
				
				Statement s2 = conn.createStatement();
				
				String str2 = "insert into student values("+id+ ",'"+ name+ "',"+marks+ ",'"+dob+ "')";
				
				int i = s2.executeUpdate(str2);
				
				System.out.println(i+" Row Added");
				
				conn.close();
			
				break;
				
			case 3:
				
				System.out.println("Enter Roll no you want to Delete : ");
				int rollno = sc.nextInt();
				
				Statement s3 = conn.createStatement();
				
				String str3 = "delete from student where rno = "+rollno;
				
				boolean val = s3.execute(str3);
				
				System.out.println(val+" Record Deleted");
				
				conn.close();
				
				break;
				
			case 4:
				
				System.out.println("Enter name you want to update : ");
				String nm = sc.next();
				
				System.out.println("Enter Your Name : ");				
				String nme = sc.next();
				
				Statement s4 = conn.createStatement();
				
				String str4 = "update student set name = '"+nme+"' where name = '"+nm+"'";
				
				s4.execute(str4);
				
				System.out.println();
				
				conn.close();
				
				break;

			default:
				System.out.println("Invalid Choice");
				break;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

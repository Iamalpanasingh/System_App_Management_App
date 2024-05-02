package Com.student;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentD {
	public static boolean insertStudentToDB(Student s)
	{
		//jdbc code
		boolean f=false;
		try {
		Connection con=ConnectionP.createConnection();
		String q="insert into student(sname,sphone,scity) values(?,?,?)";
		// prepared statement
		PreparedStatement ps=con.prepareStatement(q);
		// set parameters
		ps.setString(1, s.getStudentName());
		ps.setString(2, s.getStudentPhone());
		ps.setString(3, s.getStudentCity());
		
		//execute
		ps.executeUpdate();
		f=true;
		
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
		boolean f=false;
		try {
		Connection con=ConnectionP.createConnection();
		String q="delete from student where sid=?";
		// prepared statement
		PreparedStatement ps=con.prepareStatement(q);
		// set parameters
		ps.setInt(1, userId);
		
		//execute
		ps.executeUpdate();
		f=true;
		
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return f;
		
		
	}

	public static void showAllStudent() {
		boolean f=false;
		try {
			// JDBC code
		Connection con=ConnectionP.createConnection();
		String q="select * from student";
		Statement stmt=(Statement) con.createStatement();
		
		ResultSet set=((java.sql.Statement) stmt).executeQuery(q);
		
		while(set.next())
		{
			int id=set.getInt(1);
			String name=set.getString(2);
			String phone=set.getString(3);
			String city=set.getString("scity");
			
			System.out.println("ID : "+ id);
			System.out.println("NAME : "+ name);
			System.out.println("PHONE : "+ phone);
			System.out.println("CITY : "+ city);
			System.out.println("++++++++++++++++++++++++++++++");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}


		
	}
		
		

}

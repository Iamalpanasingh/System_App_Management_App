package Com.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionP {
	static Connection con;
	
	public static Connection createConnection() {
		try {
			
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create connection
		String user="root";
		String password="vivek@143";
		String url= "jdbc:mysql://localhost:3306/student_manage";
		con=DriverManager.getConnection(url, user , password);
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return con;
	}

}

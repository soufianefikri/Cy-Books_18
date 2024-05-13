package cyBooks18;

import java.sql.*;

public class Register {
	
	

	public void register()  {
		
		
	}
	
	void establishConnection() {
		try {
			//1.Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Establish the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_database","root","aqzsedrf963.");
			//2.1Connection CHeck
			if(connection!= null) {
				System.out.println("Espresso");
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}

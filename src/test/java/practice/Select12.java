package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class Select12 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro", "root", "root");
			Statement stat = conn.createStatement();
			String query = "Select * from project";
			
			ResultSet rs = stat.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString(1)+"/t"+rs.getString(2));
			}
		}	catch(Exception e) {
				
		}	finally {
				conn.close();
			}	
	}
}

package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelect12 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		int rs=0;
		try {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		System.out.println("connection is done");
		Statement stat = conn.createStatement();
		String query = "Insert into the values('2', 'arun', 'kumar', 'n')";
		 rs = stat.executeUpdate(query);
		}
		catch(Exception e)
		{
		}
			finally {
				if(rs==1)
					{
					System.out.println("Inserted Successfully");
					}else {
						System.out.println("Not Inserted Successfully");
					}
				conn.close();
			}
	}}

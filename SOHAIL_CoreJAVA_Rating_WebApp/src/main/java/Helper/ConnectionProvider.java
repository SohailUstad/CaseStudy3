package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	private Connection con;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Rating1","root","0000");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.con;
	}
}

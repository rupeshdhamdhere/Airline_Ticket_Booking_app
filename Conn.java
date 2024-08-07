package Airline_reservation_system;

import java.sql.*;

public class Conn {
	Connection c;
	Statement s;

	public Conn() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///airlinereservationsystem", "root", "02062003");
			s = c.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	private static final String PWD = "root";
	private static final String USER = "";
	private String conn;
	private Connection connection;

	public Conn(String conn) {
		this.conn = conn;
	}

	Connection open() {
		try {
			String url = this.conn;
			String user = USER;
			String password = PWD;

			connection = DriverManager.getConnection(url, user, password);

			return connection;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}

package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private static DBUtil instance;
	private static Connection connection = null;
	
	public DBUtil() {}
	
	public static DBUtil getInstance () {
		if (connection == null) {
			instance = new DBUtil();
		}
		return instance;
	}
	
	public Connection getConnection() {
		if (connection == null) {
			try {
				String driverName = "com.mysql.cj.jdbc.Driver";
				Class.forName(driverName);
				String url = "jdbc:mysql://localhost/pet-dm";
				String user = "teste";
				String senha = "Teste@123";
				connection = DriverManager.getConnection(url, user, senha);
			} catch (Exception e) {
				System.out.println("Erro: "+e.toString());
			}
		}
		return connection;
	}

}

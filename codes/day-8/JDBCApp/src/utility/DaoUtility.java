package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoUtility {

	private static Properties loadDbConfig() throws FileNotFoundException, IOException {
		FileReader reader = null;
		try {
			reader = new FileReader("resources//dbconfig.properties");
			Properties p = new Properties();
			p.load(reader);
			return p;
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (reader != null)
				reader.close();
		}

	}

	public static Connection createConnection() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		try {
			Properties p = loadDbConfig();
			String driverCls = p.getProperty("mysqlDriver");
			Class.forName(driverCls);
			connection = DriverManager.getConnection(p.getProperty("connectionString"), p.getProperty("userName"),
					p.getProperty("password"));

		} catch (ClassNotFoundException e) {
			throw e;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection) throws SQLException {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				throw e;
			}
	}
}

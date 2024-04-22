import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import utility.DaoUtility;

public class App {

	public static void main(String[] args) {

		Connection connection = null;
		try {
			connection = DaoUtility.createConnection();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DaoUtility.closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	static List<Employee> getRecords() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet records = null;
		List<Employee> employees = null;
		try {
			// loading MySql connector driver class (Driver)
			// dynamically
			Class.forName("com.mysql.cj.jdbc.Driver");

			String connectionString = "jdbc:mysql://localhost:3306/testdb";
			String userName = "root";
			String password = "MySql@2023";
			String query = "select * from employees";

			connection = DriverManager.getConnection(connectionString, userName, password);

			statement = connection.createStatement();
			records = statement.executeQuery(query);
			if (records != null) {
				employees = new ArrayList<Employee>();
				while (records.next()) {
					int id = records.getInt("id");
					String name = records.getString("name");
					double salary = records.getDouble("salary");
					Employee employee = new Employee(id, name, salary);
					employees.add(employee);
				}
			}
			return employees;

		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				throw e;
			}
		}
	}

	static void addRecord(Employee employee) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		String connectionString = "jdbc:mysql://localhost:3306/testdb";
		String userName = "root";
		String password = "MySql@2023";
		String query = "insert into employees(id,name,salary) values(?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionString, userName, password);
			statement = connection.prepareStatement(query);
			statement.setInt(1, employee.getId());
			statement.setString(2, employee.getName());
			statement.setDouble(3, employee.getSalary());

			int res = statement.executeUpdate();
			if (res > 0)
				System.out.println(res + " record(s) added");
			else
				System.out.println("failed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	static void updateRecord() throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		String connectionString = "jdbc:mysql://localhost:3306/testdb";
		String userName = "root";
		String password = "MySql@2023";
		String query = "update employees set name=?,salary=? where id=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionString, userName, password);
			statement = connection.prepareStatement(query);

			statement.setString(1, "vinod kumar");
			statement.setDouble(2, 5000);
			statement.setInt(3, 4);

			int res = statement.executeUpdate();
			if (res > 0)
				System.out.println(res + " record(s) updated");
			else
				System.out.println("failed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	static void deleteRecord() throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		String connectionString = "jdbc:mysql://localhost:3306/testdb";
		String userName = "root";
		String password = "MySql@2023";
		String query = "delete from employees where id=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionString, userName, password);
			statement = connection.prepareStatement(query);

			statement.setInt(1, 4);

			int res = statement.executeUpdate();
			if (res > 0)
				System.out.println(res + " record(s) deleted");
			else
				System.out.println("failed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	public static void main(String[] args) {
		try {
			
			// updateRecord();
			// deleteRecord();
//			List<Employee> list = getRecords();
//			for (Employee employee : list) {
//				System.out.println(employee);
//			}
			Scanner scanner = new Scanner(System.in);
			System.out.print("name: ");
			String name = scanner.next();
			System.out.print("id: ");
			int id = scanner.nextInt();
			System.out.print("salary: ");
			double salary = scanner.nextDouble();
			
			Employee employee = new Employee(id, name, salary);
			// addRecord(employee);
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

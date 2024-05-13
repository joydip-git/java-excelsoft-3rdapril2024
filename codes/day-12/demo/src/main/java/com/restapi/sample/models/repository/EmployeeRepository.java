package com.restapi.sample.models.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.restapi.sample.models.dto.Employee;
import com.restapi.sample.utility.DbQueries;
import com.restapi.sample.utility.DbUtility;

@Repository
public class EmployeeRepository implements RepositoryContract<Employee, Integer> {

	@Override
	public List<Employee> getRecords() throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet records = null;
		List<Employee> employeeRecords = null;
		try {
			connection = DbUtility.createConnection();

			statement = connection.createStatement();
			records = statement.executeQuery(DbQueries.SELECT_ALL_QUERY);

			if (records != null) {

				employeeRecords = new ArrayList<Employee>();

				while (records.next()) {
					int id = records.getInt("id");
					String name = records.getString("name");
					double salary = records.getDouble("salary");

					Employee employee = new Employee(id, name, salary);
					employeeRecords.add(employee);
				}
			}
			return employeeRecords;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	@Override
	public Employee getRecord(Integer id) throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet records = null;
		Employee employee = null;
		try {
			connection = DbUtility.createConnection();

			statement = connection.prepareStatement(DbQueries.SELECT_SINGLE_QUERY);
			statement.setInt(1, id);
			records = statement.executeQuery();

			if (records != null) {

				while (records.next()) {
					int eid = records.getInt("id");
					String name = records.getString("name");
					double salary = records.getDouble("salary");
					employee = new Employee(eid, name, salary);
				}
			}

			return employee;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	@Override
	public Integer addRecord(Employee modelObject) throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DbUtility.createConnection();
			statement = connection.prepareStatement(DbQueries.INSERT_QUERY);
			statement.setInt(1, modelObject.getId());
			statement.setString(2, modelObject.getName());
			statement.setDouble(3, modelObject.getSalary());
			int res = statement.executeUpdate();
			System.out.println("Repo: " + res);
			return res;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}

	}

	@Override
	public Integer updateRecord(Integer id, Employee modelObject)
			throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DbUtility.createConnection();
			statement = connection.prepareStatement(DbQueries.UPDATE_QUERY);
			statement.setString(1, modelObject.getName());
			statement.setDouble(2, modelObject.getSalary());
			statement.setInt(3, id);
			return statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	@Override
	public Integer deleteRecord(Integer id) throws ClassNotFoundException, SQLException, Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DbUtility.createConnection();
			statement = connection.prepareStatement(DbQueries.DELETE_QUERY);
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}

}

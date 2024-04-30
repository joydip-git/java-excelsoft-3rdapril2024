package com.restapi.sample.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.sample.models.dto.Employee;
import com.restapi.sample.utility.DbUtility;

@RestController
public class EmployeeController {

	public EmployeeController() {
	}

	@GetMapping(path = "/employees")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Employee>> getEmplpoyees() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet records = null;
		List<Employee> employeeRecords = null;
		try {
			connection = DbUtility.createConnection();

			statement = connection.createStatement();
			records = statement.executeQuery("select * from employees;");

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

			return ResponseEntity.ok(employeeRecords);
			// return ResponseEntity.of(Optional.of(employeeRecords));
			// return ResponseEntity.status(HttpStatus.OK).build();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		} finally {
			if (connection != null)
				connection.close();
		}

	}

	@PostMapping(path = "/employees/add")
	public ResponseEntity<Integer> addEmployee(@RequestBody Employee employee)
			throws ClassNotFoundException, SQLException, Exception {

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DbUtility.createConnection();
			statement = connection.prepareStatement("insert into employees(id,name,salary) values(?,?,?);");
			statement.setInt(1, employee.getId());
			statement.setString(2, employee.getName());
			statement.setDouble(3, employee.getSalary());
			int res = statement.executeUpdate();
			if (res > 0) {
				return ResponseEntity.of(Optional.of(res)).status(HttpStatus.CREATED).build();
			} else {
				return ResponseEntity.of(Optional.empty()).status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} catch (

		ClassNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}

	}

	@GetMapping(path = "/employees/view/{eid}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Employee> getEmplpoyeeById(@PathVariable("eid") int eid)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet records = null;
		Employee employee = null;
		try {
			connection = DbUtility.createConnection();

			statement = connection.prepareStatement("select * from employees where id=?;");
			statement.setInt(1, eid);
			records = statement.executeQuery();

			if (records != null) {

				while (records.next()) {
					int id = records.getInt("id");
					String name = records.getString("name");
					double salary = records.getDouble("salary");
					employee = new Employee(id, name, salary);
				}
			}

			return ResponseEntity.ok(employee);
			// return ResponseEntity.of(Optional.of(employeeRecords));
			// return ResponseEntity.status(HttpStatus.OK).build();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		} finally {
			if (connection != null)
				connection.close();
		}

	}
}

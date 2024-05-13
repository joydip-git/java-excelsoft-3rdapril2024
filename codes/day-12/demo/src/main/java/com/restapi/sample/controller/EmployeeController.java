package com.restapi.sample.controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.sample.models.dto.Employee;
import com.restapi.sample.models.services.ServiceContract;

@RestController
public class EmployeeController {

	@Autowired
	private ServiceContract<Employee, Integer> _service;

	@GetMapping(path = "/employees/sort/{sortchoice}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Employee>> getEmplpoyees(@PathVariable("sortchoice") int sortChoice)
			throws ClassNotFoundException, SQLException {
		try {
			List<Employee> employeeRecords = _service.fetchRecords(sortChoice);
			System.out.println("request came");
			return ResponseEntity.ok(employeeRecords);
			// return new ResponseEntity<List<Employee>>(employeeRecords, HttpStatus.FOUND);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping(path = "/employees/add")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
			throws ClassNotFoundException, SQLException, Exception {
		try {
			Employee res = _service.insertRecord(employee);
			System.out.println("Repo: " + res);
			if (res != null) {
				return new ResponseEntity<Employee>(res, HttpStatus.CREATED);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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

	@PutMapping(path = "/employees/update/{eid}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("eid") int id)
			throws ClassNotFoundException, SQLException, Exception {
		try {
			Employee res = _service.modifyRecord(id, employee);
			if (res != null) {
				// return
				// ResponseEntity.of(Optional.of(res)).status(HttpStatus.CREATED).build();
				return new ResponseEntity<Employee>(res, HttpStatus.OK);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} catch (ClassNotFoundException e) {
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
		try {
			Employee employee = _service.fetchRecord(eid);
			return ResponseEntity.ok(employee);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping(path = "/employees/delete/{eid}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Integer> deleteEmplpoyeeById(@PathVariable("eid") int eid)
			throws ClassNotFoundException, SQLException {
		try {
			int res = _service.removeRecord(eid);
			return ResponseEntity.ok(res);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
}

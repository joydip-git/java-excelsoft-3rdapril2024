package com.restapi.sample.models.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.sample.models.dto.Employee;
import com.restapi.sample.models.repository.RepositoryContract;

@Service
public class EmployeeService implements ServiceContract<Employee, Integer> {

	@Autowired
	private RepositoryContract<Employee, Integer> _repository;

	@Override
	public List<Employee> fetchRecords(int sortingChoice) throws ClassNotFoundException, SQLException, Exception {
		try {
			List<Employee> employees = _repository.getRecords();
			List<Employee> sortedEmployees = null;
			switch (sortingChoice) {
			case 1:
				sortedEmployees = employees.stream().sorted((e1, e2) -> Integer.compare(e1.getId(), e2.getId()))
						.toList();
				break;

			case 2:
				sortedEmployees = employees.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).toList();
				break;

			case 3:
				sortedEmployees = employees.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
						.toList();
				break;

			default:
				sortedEmployees = employees.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).toList();
				break;
			}
			return sortedEmployees;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Employee fetchRecord(Integer id) throws ClassNotFoundException, SQLException, Exception {
		try {
			if (id <= 0)
				throw new IllegalArgumentException("the employee id should be greater than zero");

			return _repository.getRecord(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Employee insertRecord(Employee modelObject) throws ClassNotFoundException, SQLException, Exception {
		try {
			if (modelObject == null)
				throw new NullPointerException("employee object is NULL");
			
			List<Employee> records = _repository.getRecords();
			Employee lastEmployee = records.get(records.size()-1);
			System.out.println(modelObject);
			System.out.println(lastEmployee);
			modelObject.setId(lastEmployee.getId() + 1);
			System.out.println(modelObject.getId());
			int res = _repository.addRecord(modelObject);
			if(res>0)
				return modelObject;
			else
				return null;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Employee modifyRecord(Integer id, Employee modelObject)
			throws ClassNotFoundException, SQLException, Exception {
		try {
			if (modelObject == null)
				throw new NullPointerException("employee object is NULL");

			if (id <= 0)
				throw new IllegalArgumentException("the employee id should be greater than zero");

			int res = _repository.updateRecord(id, modelObject);
			if(res>0)
				return modelObject;
			else
				return null;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw e;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Integer removeRecord(Integer id) throws ClassNotFoundException, SQLException, Exception {
		try {
			if (id <= 0)
				throw new IllegalArgumentException("the employee id should be greater than zero");

			return _repository.deleteRecord(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}

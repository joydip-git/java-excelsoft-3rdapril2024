package com.restapi.sample.utility;

public class DbQueries {
	public final static String SELECT_ALL_QUERY = "select * from employees;";
	public final static String SELECT_SINGLE_QUERY = "select * from employees where id=?;";
	public final static String INSERT_QUERY = "insert into employees(id,name,salary) values(?,?,?);";
	public final static String UPDATE_QUERY = "update employees set name=?, salary=? where id=?;";
	public final static String DELETE_QUERY = "delete from employees where id=?;";
}

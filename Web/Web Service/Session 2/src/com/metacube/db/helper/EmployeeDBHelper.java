package com.metacube.db.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacube.EmployeeSystemException;
import com.metacube.db.ConnectionFactory;
import com.metacube.model.Employee;

/**
 * Class is used to perform operations on database
 *
 */
public class EmployeeDBHelper {
	
	private static final String GET_EMPLOYEE_LIST_QUERY = "SELECT * FROM Employee";
	private static final String GET_EMPLOYEE_BY_ID_QUERY = "SELECT * FROM Employee where id = ?";
	private static final String GET_EMPLOYEE_BY_NAME_QUERY = "SELECT * FROM Employee where name = ?";
	private static final String CREATE_EMPLOYEE_QUERY = "insert into Employee(name,email,address) values(?,?,?);";
	private static final String DELETE_EMPLOYEE_BY_ID_QUERY = "delete from Employee where id = ?";
	
	/**
	 * method is used to insert new employee in database
	 * @param employee: hold employee attributes
	 * @return if 1 for inserted successfully or 0 for data is not inserted
	 * @throws EmployeeSystemException
	 */
	public int createEmployee(Employee employee) throws EmployeeSystemException {
		Connection connection = ConnectionFactory.getConnection();
		int isInsert = 0;
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE_QUERY);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getAddress());
			isInsert = preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				
				System.out.println("Conection can not rollback due to : "+e.getMessage());
			}
			throw new EmployeeSystemException("Exception while insert employee: "+e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return isInsert;
	}
	
	/**
	 * to get list of all employees which are present in database
	 * @return list of all employees
	 * @throws EmployeeSystemException
	 */
	public List<Employee> getEmployeeList() throws EmployeeSystemException {
		
		List<Employee> employeeList = new ArrayList<Employee>();
		Connection connection  = ConnectionFactory.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(GET_EMPLOYEE_LIST_QUERY);
			while(resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setAddress(resultSet.getString("address"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			throw new EmployeeSystemException("Exception while getting list of Employees: "+e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection);
		}	
		return employeeList;
	}
	
	/**
	 * to retrieve employee details who has particular id 
	 * @param id: id of employee
	 * @return Employee object corresponding to id
	 * @throws EmployeeSystemException
	 */
	public Employee getEmployeeById(int id) throws EmployeeSystemException {
		Employee employee = null;
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_EMPLOYEE_BY_ID_QUERY);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				employee = new Employee();
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setAddress(resultSet.getString("address"));
				}
			} catch (SQLException e) {
				throw new EmployeeSystemException("Exception while getting Employee Description "+e.getMessage());
			} finally {
				ConnectionFactory.closeConnection(connection);
			}
		return employee;
	}
	
	/**
	 * to get list of employees from database basis on a particular name
	 * @param name: name of employees
	 * @return employees list corresponding to name
	 * @throws EmployeeSystemException
	 */
	public List<Employee> getEmployeeByName(String name) throws EmployeeSystemException {
		Employee employee = null;
		List<Employee> employees = new ArrayList<Employee>();
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_EMPLOYEE_BY_NAME_QUERY);
			preparedStatement.setString(1,name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setAddress(resultSet.getString("address"));
				employees.add(employee);
				}
			} catch (SQLException e) {
				throw new EmployeeSystemException("Exception while getting Employee Description "+e.getMessage());
			} finally {
				ConnectionFactory.closeConnection(connection);
			}
		return employees;
	}
	
	/**
	 * to delete employee from database by its id
	 * @param id: id of employee which is going to be deleted
	 * @return 1 if employee is deleted or 0 for employee isn't deleted
	 * @throws EmployeeSystemException
	 */
	public int deleteEmployeeById(int id) throws EmployeeSystemException {
		int isDelete = 0;
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID_QUERY);
			preparedStatement.setInt(1,id);
			isDelete = preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				
				System.out.println("Conection can not rollback due to : "+e.getMessage());
			}
			throw new EmployeeSystemException("Exception while getting Employee Description "+e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return isDelete;
	}
}

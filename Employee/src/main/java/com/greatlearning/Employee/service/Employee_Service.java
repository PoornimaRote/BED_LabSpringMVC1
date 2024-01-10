package com.greatlearning.Employee.service;

import java.util.List;

import com.greatlearning.Employee.data.Employee;

public interface Employee_Service {
	List<Employee> getAllEmployees();
	void addNewEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployeeById(int empId);
	Employee getEmployeeById(int empId);
}

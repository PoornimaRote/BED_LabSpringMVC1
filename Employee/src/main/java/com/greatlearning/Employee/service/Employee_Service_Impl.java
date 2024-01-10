package com.greatlearning.Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.Employee.data.Employee;
import com.greatlearning.Employee.repository.Employee_Repository;

@Service
public class Employee_Service_Impl implements Employee_Service {
	private Employee_Repository repository;

	@Autowired
	public Employee_Service_Impl(Employee_Repository repository) {
		this.repository = repository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public void addNewEmployee(Employee employee) {
		repository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		repository.save(employee);
	}

	@Override
	public void deleteEmployeeById(int empId) {
		repository.deleteById(empId);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return repository.findById(empId).orElse(null);
	}
}

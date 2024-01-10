package com.greatlearning.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.Employee.data.Employee;

@Repository
public interface Employee_Repository extends JpaRepository<Employee, Integer> {

}

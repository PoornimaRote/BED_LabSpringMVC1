package com.greatlearning.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.Employee.data.Employee;
import com.greatlearning.Employee.service.Employee_Service;

@Controller
public class Employee_Controller {
	private Employee_Service service;

	@Autowired
	public Employee_Controller(Employee_Service service) {
		this.service = service;
	}

	@GetMapping("/employees")
	public String getAllEmployees(Model model) {
		model.addAttribute("employees", service.getAllEmployees());
		return "employees";
	}

	@GetMapping("/employees/new")
	public String newEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "create_employee";
	}

	@GetMapping("/employees/edit/{id}")
	public String editEmployee(Model model, @PathVariable("id") int empId) {
		Employee employee = service.getEmployeeById(empId);
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	@PostMapping("/employees")
	public String saveNewEmployee(@ModelAttribute("employee") Employee employee) {
		service.addNewEmployee(employee);
		return "redirect:/employees";
	}

	@PostMapping("/employees/{id}")
	public String saveUpdatedEmployee(@ModelAttribute("employee") Employee employee, @PathVariable("id") int empId) {
		Employee existingEmp = service.getEmployeeById(empId);
		existingEmp.setFirstName(employee.getFirstName());
		existingEmp.setLastName(employee.getLastName());
		existingEmp.setEmail(employee.getEmail());
		service.addNewEmployee(existingEmp);
		return "redirect:/employees";
	}

	@GetMapping("/employees/delete/{id}")
	public String editEmployee(@PathVariable("id") int empId) {
		service.deleteEmployeeById(empId);
		return "redirect:/employees";
	}

}

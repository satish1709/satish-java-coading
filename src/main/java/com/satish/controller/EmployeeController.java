package com.satish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satish.madel.Employee;
import com.satish.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateEmployee/{eId}/{aId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("eId")Long eId, @PathVariable("aId")Long aId){
		Employee employee = employeeService.updateEmployee(eId,aId);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	
	@GetMapping("/employeeByName/{name}")
	public ResponseEntity<Employee> findByName(@PathVariable("name") String name){
		Employee employee = employeeService.findByName(name);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.getAllEMployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/empByCompany/{company}")
	public ResponseEntity<List<Employee>> getByCompany(@PathVariable("company") String comp){
		List<Employee> emps = employeeService.getByCompany(comp);
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
	
	@GetMapping("/empGrade/{grade}")
	public ResponseEntity<List<Employee>> getEmployeesLessGrade(@PathVariable("grade") Double grade){
		List<Employee> emp = employeeService.findByGradeLessThan(grade);
		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
	}

}

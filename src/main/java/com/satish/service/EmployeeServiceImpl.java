package com.satish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satish.madel.Address;
import com.satish.madel.Employee;
import com.satish.repository.AddressRepository;
import com.satish.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Long eId, Long aId) {
		Address address = addressRepository.findById(aId).orElse(null);
		Employee employee = employeeRepository.findById(eId).get();
		employee.setAddress(address);
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> getAllEMployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getByCompany(String comp) {
		return employeeRepository.findByCompany(comp);
	}

	@Override
	public List<Employee> findByGradeLessThan(Double grade) {
		return employeeRepository.findByGradeLessThan(grade);
	}


}

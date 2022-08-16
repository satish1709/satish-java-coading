package com.satish.service;


import java.util.List;

import com.satish.madel.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	Employee updateEmployee(Long eId, Long aId);

	Employee findByName(String name);

	List<Employee> getAllEMployees();

	List<Employee> getByCompany(String comp);

	List<Employee> findByGradeLessThan(Double grade);

}

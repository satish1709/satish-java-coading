package com.satish.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satish.madel.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByName(String name);

	List<Employee> findByCompany(String comp);

	List<Employee> findByGradeLessThan(Double grade);

}

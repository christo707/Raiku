package com.raiku.curiosity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.raiku.curiosity.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//@Query("SELECT e FROM Employee e WHERE e.designation = ?1")
	List<Employee> findByDesignation(String designation); 

}

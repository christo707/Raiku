package com.raiku.curiosity.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raiku.curiosity.entities.Employee;

@Service
@Transactional
public interface EmloyeeService {
	public Boolean createEmployee(Employee emp);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployee();
	public List<Employee> getEmployeeByDesg(String desg);
}

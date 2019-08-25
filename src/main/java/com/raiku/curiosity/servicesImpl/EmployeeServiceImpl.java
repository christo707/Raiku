package com.raiku.curiosity.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raiku.curiosity.entities.Employee;
import com.raiku.curiosity.repository.EmployeeRepository;
import com.raiku.curiosity.services.EmloyeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmloyeeService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmloyeeService.class);

	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Boolean createEmployee(Employee emp) {
		try {
			employeeRepository.save(emp);
			logger.info("Employee Created");
			return true;
		} catch(Exception e) {
			logger.info("Error in creating Employee");
			return false;
		}
	}

	@Override
	public Employee getEmployee(int id) {
			Optional<Employee> e = employeeRepository.findById(id);
			if(e.isPresent()) {
				logger.info("Employee Found");
				return e.get();
			} else {
				logger.info("Employee Not Found");
				return null;
			}
	}

	@Override
	public List<Employee> getAllEmployee() {
		try {
			List<Employee> e = employeeRepository.findAll();
			logger.info("Employees List Found");
			return e;
		} catch(Exception e) {
			logger.info("Employees List Not Found");
			return null;
		}
	}

	@Override
	public List<Employee> getEmployeeByDesg(String desg) {
		try {
			List<Employee> e = employeeRepository.findByDesignation(desg);
			logger.info("Employees List Found");
			return e;
		} catch(Exception e) {
			logger.info("Employees List Not Found");
			return null;
		}
	}

}

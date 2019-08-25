package com.raiku.curiosity.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raiku.curiosity.entities.Employee;
import com.raiku.curiosity.entities.Test;
import com.raiku.curiosity.services.EmloyeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	@Autowired
	EmloyeeService empService; 
	
	@RequestMapping(value = "/findAll",  method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Employee>> findAll(){
			List<Employee> e = empService.getAllEmployee();
			 if (e == null) {
		            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		        }
		        return new ResponseEntity<List<Employee>>(e, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findById/{id}",  method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Employee> findyId(@PathVariable("id") int id){
			Employee e = empService.getEmployee(id);
			 if (e == null) {
		            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		        }
		        return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create",  method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> createEmployee(@RequestBody Employee emp){
		System.out.println(emp);	
		Boolean e = empService.createEmployee(emp);
			 if (e == false) {
		            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		        }
		        return new ResponseEntity<String>("Employee created Done", HttpStatus.CREATED);
	}

}

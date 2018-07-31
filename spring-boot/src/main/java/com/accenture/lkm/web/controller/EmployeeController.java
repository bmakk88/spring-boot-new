package com.accenture.lkm.web.controller;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.

import com.accenture.lkm.bussiness.bean.Employee;
import com.accenture.lkm.dao.EmployeeDAO;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@RequestMapping(value="emp/controller/getDetails",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployeeDetails(){
		List<Employee> listEmployee =
				new ArrayList<Employee> (employeeDAO.getAllEmployee());
		
		return new ResponseEntity<List<Employee>> (listEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(value = "emp/controller/getDetailsById/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeDetailsById(
			@PathVariable("id") int myId) {
		Employee employee = employeeDAO.getEmployeeDetailsById(myId);
		
		if(employee !=null) {
			return new ResponseEntity<Employee> (employee,
					HttpStatus.OK);
		}else {
			return new ResponseEntity<Employee> (employee,
					HttpStatus.NOT_FOUND);
		}
	}
	
	
		@RequestMapping(value = "emp/controller/addEmp",
				method = RequestMethod.POST,
				consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> addEmployee
		(@Valid @RequestBody Employee employee, Errors err){
				
			
			
			if(err.hasErrors()) {
				System.out.println("error");
				return new ResponseEntity<String>(err.getAllErrors().toString(),HttpStatus.BAD_REQUEST);
			}
			
			int count = employeeDAO.addEmployee(employee);
			
			return new ResponseEntity<String> ("success"+count,HttpStatus.OK);
			}
		
	}
	
	


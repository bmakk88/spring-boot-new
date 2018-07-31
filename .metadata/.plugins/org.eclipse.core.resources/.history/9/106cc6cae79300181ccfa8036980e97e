package com.accenture.lkm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.lkm.dao.EmployeeDAOWrapper;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDAOWrapper employeeDAO;
	
	@RequestMapping(value ="emp/controller/getDetails",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE);
	
	public ResponseEntity<List<Employee>> getEmployeeDetails() {
		List<Employee> listEmployee =
				new ArrayList<Employee> (employeeDAO.findAll());
		
		return new ResponseEntity<List<Employee>> (listEmployee,HttpStatus.OK);
	}
	
}

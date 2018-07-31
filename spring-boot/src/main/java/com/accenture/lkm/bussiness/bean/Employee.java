package com.accenture.lkm.bussiness.bean;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

public class Employee {


	private int employeeId;
	
	@NotEmpty(message="Name Should not be empty")
	private String employeeName;
	
	@Range(min=10, max=20000,message="Salary should be in the range")
	private Double salary;
	
		private Integer departmentCode; 
	
	
	public Employee(int employeeId, String employeeName, Double salary, Integer departmentCode) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.departmentCode = departmentCode;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(Integer departmentCode) {
		this.departmentCode = departmentCode;
	}
	
 

}
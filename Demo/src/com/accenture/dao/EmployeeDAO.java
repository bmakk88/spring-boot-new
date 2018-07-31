package com.accenture.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.accenture.entity.EmployeeEntityBean;


public interface EmployeeDAO extends CrudRepository<EmployeeEntityBean, Integer> {
	
	List<EmployeeEntityBean> findBySalaryGreaterThanEqual(double salary);
	
	List<EmployeeEntityBean> findBySalaryGreaterThanAndRole(double salary,String role);
	
	@Query("select k from EmployeeEntityBean k where k.salary>=?1")
	List<EmployeeEntityBean> getAllEmployeesBySalary(Double salary);
	
	@Query("select k from EmployeeEntityBean k where k.name=?1")
	List<EmployeeEntityBean> getAllEmployeesByName(String name);
	
	@Query("select k from EmployeeEntityBean k where k.name=:nam")
	List<EmployeeEntityBean> getAllEmployeesByName1(@Param("nam")String name);
	

}

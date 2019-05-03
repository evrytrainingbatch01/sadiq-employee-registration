package com.evry.employee.service;

import java.util.List;

import com.evry.employee.entity.EmployeeEntity;
/**
 * 
 * @author sadiq.ahamad
 *
 */
public interface EmployeeService {

	public EmployeeEntity addEmployee(EmployeeEntity employeeEntity);

	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

	public EmployeeEntity getEmployee(int id);

	public void deleteEmployee(int id);

	public List<EmployeeEntity> getAllEmployees();

}

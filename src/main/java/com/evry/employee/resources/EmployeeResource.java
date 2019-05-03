package com.evry.employee.resources;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.evry.employee.entity.EmployeeEntity;

/**
 * 
 * @author sadiq.ahamad
 *
 */
@WebService
public interface EmployeeResource {

	@WebMethod
	public EmployeeEntity addEmployee(EmployeeEntity employeeEntity);

	@WebMethod
	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

	@WebMethod
	@WebResult(name="id")
	public EmployeeEntity getEmployee(int id);
	

	@WebMethod
	public List<EmployeeEntity> deleteEmployee(int id);

	@WebMethod
	public List<EmployeeEntity> getAllEmployees();

}

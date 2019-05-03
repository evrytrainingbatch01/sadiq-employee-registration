package com.evry.employee.resources;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.evry.employee.entity.EmployeeEntity;
import com.evry.employee.service.EmployeeService;
/**
 * 
 * @author sadiq.ahamad
 *
 */
@WebService(endpointInterface="com.evry.employee.resources.EmployeeResource")
public class EmployeeResourceImpl implements EmployeeResource {

	/*
	 * @Inject private EmployeeService employeeService;
	 */

	// private EmployeeService employeeService = new EmployeeServiceImpl();
	@Autowired
	private EmployeeService employeeService;

	@Override
	public EmployeeEntity addEmployee(EmployeeEntity employeeEntity) {
		System.out.println(employeeEntity);
		EmployeeEntity employee = employeeService.addEmployee(employeeEntity);
		return employee;
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		return employeeService.updateEmployee(employeeEntity);
	}

	@Override
	public EmployeeEntity getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeService.getEmployee(id);
	}

	@Override
	public List<EmployeeEntity> deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeService.deleteEmployee(id);
		
		return employeeService.getAllEmployees();
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeService.getAllEmployees();
	}

}

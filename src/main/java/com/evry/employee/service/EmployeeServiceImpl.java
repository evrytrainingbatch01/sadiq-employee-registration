package com.evry.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.employee.dao.EmployeeDao;
import com.evry.employee.entity.EmployeeEntity;

/**
 * 
 * @author sadiq.ahamad
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	/*
	 * @Inject private EmployeeDao employeeDao;
	 */

	// private EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public EmployeeEntity addEmployee(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		return employeeDao.save(employeeEntity);
		}

	@Override
	public EmployeeEntity getEmployee(int id) {
		 Optional<EmployeeEntity> emp = employeeDao.findById(id);
		 EmployeeEntity entity = emp.get();
		 return entity;
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		return employeeDao.save(employeeEntity);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeDao.deleteById(id);
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

}

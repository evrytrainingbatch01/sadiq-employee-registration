package com.evry.employee.dao;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.evry.employee.entity.EmployeeEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRegistrationAppApplicationTests {
	
	@Autowired
	private TestEntityManager entityManager;	
	
	EmployeeEntity empObj= new EmployeeEntity();
	
	
	private EmployeeEntity initializeEmployee() {
		
		empObj.setEmployeeName("pk");
		empObj.setEmployeePhoneNumber(8900);
		empObj.setEmployeeAddress("Bengaluru");
		empObj.setEmployeeEmailId("gsa@evry");
		//empObj.setEmployeeId(1);
		empObj.setEmployeePassword("pk");
		return empObj;
	}
	
	@Test
	public void testaddEmployee() {
	
		EmployeeEntity employee = initializeEmployee();
		EmployeeEntity persist = entityManager.persist(employee);
		
		assertEquals(persist.getEmployeeId(), employee.getEmployeeId());
	}

	@Test
	public void testUpdateEmployee() {
		
		EmployeeEntity empAdd = entityManager.persist(initializeEmployee());
		String employeeAddress = empAdd.getEmployeeAddress();
	
		EmployeeEntity empUpdate = entityManager.merge(updateEmployee());
		String employeeAddress2 = empUpdate.getEmployeeAddress();
		assertEquals(empAdd.getEmployeeId(), empUpdate.getEmployeeId());
		assertEquals(empUpdate.getEmployeePassword(), empAdd.getEmployeePassword());
		assertThat(employeeAddress).isNotEqualTo(employeeAddress2);
		
	}
	private EmployeeEntity updateEmployee() {
		// TODO Auto-generated method stub
		empObj.setEmployeeName("sadiq");
		empObj.setEmployeePhoneNumber(8900);
		empObj.setEmployeeAddress("Hyd");
		empObj.setEmployeeEmailId("gsa@evry");
		empObj.setEmployeeId(1);
		empObj.setEmployeePassword("pk");
		return empObj;
		
	}
	
	@Test
	public void testGetEmployee() {
	
		
		EmployeeEntity empAdd = entityManager.persist(initializeEmployee());
		
		EmployeeEntity empTest = entityManager.find(empAdd.getClass(), empAdd.getEmployeeId());
		
		assertEquals(empAdd.getEmployeeEmailId(), empTest.getEmployeeEmailId());
		
	}
	@Test
	public void testDeleteEmployee() {
		// TODO Auto-generated method stub
		EmployeeEntity empAdd = entityManager.persist(initializeEmployee());
		entityManager.remove(empAdd);
		assertNull(entityManager.find(EmployeeEntity.class, empAdd.getEmployeeId()));
		
	}

}

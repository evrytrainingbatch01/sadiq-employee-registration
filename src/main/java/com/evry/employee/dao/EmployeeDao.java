package com.evry.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evry.employee.entity.EmployeeEntity;

/**
 * 
 * @author sadiq.ahamad
 *
 */
@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {

	
}

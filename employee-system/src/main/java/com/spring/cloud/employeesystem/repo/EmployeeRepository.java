 package com.spring.cloud.employeesystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.cloud.employeesystem.entity.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query("select e from Employee e where e.deptName = ?1")
	public List<Employee> findAllBydeptName(String deptName);
	
	@Query(value = "Select * From Employee e Left Join Company c On e.company_comp_id = c.comp_id Where c.comp_name = ?1", 
			nativeQuery = true)
	List<Employee> findAllByCompName(String compName);
	
}

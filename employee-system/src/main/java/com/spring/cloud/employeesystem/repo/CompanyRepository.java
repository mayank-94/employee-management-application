package com.spring.cloud.employeesystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.cloud.employeesystem.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {	
	
}

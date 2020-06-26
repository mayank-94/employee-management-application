package com.spring.cloud.employeesystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.employeesystem.entity.Company;
import com.spring.cloud.employeesystem.entity.Employee;
import com.spring.cloud.employeesystem.repo.CompanyRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/api")
@Api(value = "Company Controller")
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@GetMapping(path = "/companies/{id}/employees")
	@ApiOperation(value = "Fetch All Employees of a Company")
	public ResponseEntity<List<Employee>> retrieveAllEmployeesByCompanyId(@ApiParam(value = "Takes company Id")
					@PathVariable int id){
		
		Optional<Company> company = companyRepo.findById(id);
		return new ResponseEntity<List<Employee>>(company.get().getEmployee(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/companies/")
	@ApiOperation(value = "Fetch All Companies")
	public ResponseEntity<List<Company>> retrieveAllCompanies(){
		
		return new ResponseEntity<List<Company>>(companyRepo.findAll(), HttpStatus.OK);
	}
}

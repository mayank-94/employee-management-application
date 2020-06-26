package com.spring.cloud.employeesystem.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.cloud.employeesystem.entity.Employee;
import com.spring.cloud.employeesystem.entity.Pan;
import com.spring.cloud.employeesystem.exception.EmployeeNotFoundException;
import com.spring.cloud.employeesystem.repo.EmployeeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/api")
@Validated
@Api(value = "Employee Controller")
public class EmployeController {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@GetMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get Employee By Id")
	public ResponseEntity<Employee> getEmployeeById(@ApiParam(value = "Id, based on which Employee is fetched") 
					@PathVariable int id){
		
		Optional<Employee> employee = employeeRepo.findById(id);
		if(!employee.isPresent())
			throw new EmployeeNotFoundException("Employee with "+id+" doesn't exist");
		
		return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/employees/department/{deptName}")
	@ApiOperation(value = "Get All Employees in a Department")
	public ResponseEntity<List<Employee>> gettAllEmpByDept(@ApiParam(value = "deptName, based on which Employees are fetched")
					@PathVariable String deptName){
		
		return new ResponseEntity<List<Employee>>(employeeRepo.findAllBydeptName(deptName),
				HttpStatus.OK);
	}
	
	@GetMapping(path = "/employees")
	@ApiOperation(value = "Get List of All Employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		return new ResponseEntity<List<Employee>>(employeeRepo.findAll(), 
				HttpStatus.OK);
	}
	
	@GetMapping(path = "/employees/sorted")
	@ApiOperation(value = "Get List of All Employees in Ascending Order")
	public ResponseEntity<List<Employee>> getAllEmployeesSorted(){
		
		Sort sort = Sort.by(Sort.Direction.ASC, "deptName").and(Sort.by(Sort.Direction.DESC, "empName"));
		return new ResponseEntity<List<Employee>>(employeeRepo.findAll(sort), 
				HttpStatus.OK);
	}
	
	@GetMapping(path = "/employees/paginated")
	@ApiOperation(value = "Get List of All Employees in Pagination of 3")
	public ResponseEntity<List<Employee>> getAllEmployeesPaginated(){
		
		PageRequest pageable = PageRequest.of(0, 3, Sort.by(Sort.Direction.ASC, "empName"));
		Page<Employee> page = employeeRepo.findAll(pageable);
		
		return new ResponseEntity<List<Employee>>(page.getContent(), 
				HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/employees/{id}")
	@ApiOperation(value = "Delete Employee based on Id")
	public ResponseEntity<Void> deleteEmployeeById(@ApiParam(value="Id, based on which Employee is deleted") 
					@PathVariable int id){
		
		Optional<Employee> employee = employeeRepo.findById(id);
		if(!employee.isPresent())
			throw new EmployeeNotFoundException("Can't Delete, Employee with "+id+" doesn't exist");
		
		employeeRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(path = "/employees")
	@ApiOperation(value = "Create a New Employee")
	public ResponseEntity<Object> saveEmployee(@ApiParam(value = "Takes Employee details") 
					@Valid @RequestBody Employee employee){
		
		Employee save = employeeRepo.save(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(save.getEmpId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path = "/employees/{id}")
	@ApiOperation(value = "Update Employee details")
	public ResponseEntity<Employee> updateEmployee(@ApiParam(value = "Takes id as parameter to update details") 
					@PathVariable int id, 
					@ApiParam(value = "Takes new Employee details that will be updated") 
					@Valid @RequestBody Employee employee){
		
		Optional<Employee> currentEmployee = employeeRepo.findById(id);
		if(!currentEmployee.isPresent())
			throw new EmployeeNotFoundException("Employee with id "+id+" doesn't exist, can't update details");
		
		Employee updatedEmployee = currentEmployee.get();
		updatedEmployee.setEmpName(employee.getEmpName());
		updatedEmployee.setDeptName(employee.getDeptName());
		updatedEmployee.setBirthDate(employee.getBirthDate());
		
		employeeRepo.save(updatedEmployee);
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
	}
	
	@GetMapping(path = "/employees/{id}/pan")
	@ApiOperation(value = "Get Pan Details by Employee Id")
	public ResponseEntity<Pan> getPanByEmployeeId(@ApiParam(value = "Takes employee Id") 
					@PathVariable int id){
		
		Optional<Employee> employee = employeeRepo.findById(id);
		if(!employee.isPresent())
			throw new EmployeeNotFoundException("Employee with id "+id+" doesn't exist");
		
		Pan pan = employee.get().getPan();
		return new ResponseEntity<Pan>(pan, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/employees/company/{compName}")
	public ResponseEntity<List<Employee>> retrieveAllEmployeesByCompName(@PathVariable String compName){
		
		return new ResponseEntity<List<Employee>>(employeeRepo.findAllByCompName(compName), 
					HttpStatus.OK);
	}
}

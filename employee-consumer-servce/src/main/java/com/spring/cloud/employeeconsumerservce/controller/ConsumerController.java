package com.spring.cloud.employeeconsumerservce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.employeeconsumerservce.entity.EmployeeBean;
import com.spring.cloud.employeeconsumerservce.proxy.EmployeeProxy;
import com.spring.cloud.employeeconsumerservce.service.HystrixService;

@RestController
@RequestMapping(path = "/api/consumer")
public class ConsumerController {
	
	@Autowired
	private HystrixService service;
	
	@Autowired
	private EmployeeProxy proxy;
	
	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<EmployeeBean> findEmployee(@PathVariable int id){
		EmployeeBean employee = service.retrieveEmployeeById(id);
		return new ResponseEntity<EmployeeBean>(employee, HttpStatus.OK);
	}
	
	@GetMapping(path = "/employees")
	public ResponseEntity<List<EmployeeBean>> findAllEmployees(){
		return new ResponseEntity<List<EmployeeBean>>(proxy.retrieveAll(), HttpStatus.OK);
	}
}

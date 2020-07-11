package com.spring.cloud.employeeconsumerservce.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.employeeconsumerservce.entity.EmployeeBean;
import com.spring.cloud.employeeconsumerservce.proxy.EmployeeProxy;

@Service
public class HystrixService {
	
	@Autowired
	private EmployeeProxy proxy;
	
	@HystrixCommand(fallbackMethod = "retrieveEmployeeByIdFallback")
	public EmployeeBean retrieveEmployeeById(int id) {
		return proxy.retrieveEmployee(id);
	}
	
	public EmployeeBean retrieveEmployeeByIdFallback(int id) {
		return new EmployeeBean(101, "Fall-Back Employee", "Fall-Back Department", new Date());
	}
	
}

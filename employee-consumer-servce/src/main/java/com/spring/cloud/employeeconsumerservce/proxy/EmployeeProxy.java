package com.spring.cloud.employeeconsumerservce.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.cloud.employeeconsumerservce.entity.EmployeeBean;

@FeignClient(name = "employee-system", url = "localhost:8080")
public interface EmployeeProxy {
	
	@GetMapping(path = "/api/employees/{id}")
	public EmployeeBean retrieveEmployee(@PathVariable("id") int id);
	
	@GetMapping(path = "/api/employees/")
	public List<EmployeeBean> retrieveAll();
	
}

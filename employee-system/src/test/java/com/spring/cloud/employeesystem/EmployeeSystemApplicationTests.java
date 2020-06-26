package com.spring.cloud.employeesystem;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.spring.cloud.employeesystem.entity.Employee;
import com.spring.cloud.employeesystem.repo.EmployeeRepository;

@SpringBootTest
class EmployeeSystemApplicationTests {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	@Transactional
	void findPanByEmployeeId() {
		Optional<Employee> employee = empRepo.findById(10001);
		logger.info("Employee Details of Id 10001 -> {}", employee.get());
		logger.info("Pan Details of employee 10001-> {}", employee.get().getPan());
	}

}

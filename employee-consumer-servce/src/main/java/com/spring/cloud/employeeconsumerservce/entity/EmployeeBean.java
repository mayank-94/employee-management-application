package com.spring.cloud.employeeconsumerservce.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class EmployeeBean {
	
	private int empId;
	private String empName;
	private String deptName;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private Date birthDate;
	
	public EmployeeBean() {
		super();
	}
	
	public EmployeeBean(int empId, String empName, String deptName, Date birthDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptName = deptName;
		this.birthDate = birthDate;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", empName=" + empName + ", deptName=" + deptName + ", birthDate="
				+ birthDate + "]";
	}
	
}

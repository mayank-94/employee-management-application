package com.spring.cloud.employeesystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Employee Entity")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name = "emp_id")
	@ApiModelProperty(value = "emp_id, Primary Key of Employee Entity")
	private int empId;
	
	@Column(name = "emp_name")
	@NotNull(message = "Name can't be null")
	@ApiModelProperty(value = "empNamqe, Employee Name, can't be null")
	private String empName;
	
	@Column(name = "dept_name")
	@Size(min = 3, message = "Minimum characters in department are 3")
	@ApiModelProperty(value = "deptName, Department Name, Minimum 3 characters")
	private String deptName;

	@Column(name = "birth_date")
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	@Past(message = "Date of birth, can't be future date")
	@ApiModelProperty(value = "birthDate, Date of birth can't be Future date")
	private Date birthDate;
	
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "pan_id")
	private Pan pan;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "comp_id")
	private Company company;
		
	public Employee() {
		super();
	}

	public Employee(String empName, String deptName, Date birthDate) {
		super();
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

	public Pan getPan() {
		return pan;
	}

	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptName=" + deptName + ", birthDate="
				+ birthDate + "]";
	}
}

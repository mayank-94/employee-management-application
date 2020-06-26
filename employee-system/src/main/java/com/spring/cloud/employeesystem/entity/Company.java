package com.spring.cloud.employeesystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Company Entity")
public class Company {
	
	@Id
	@GeneratedValue
	@Column(name = "comp_id")
	@ApiModelProperty(value = "compId, Primary key of Company Entity")
	private int compId;
	
	@Column(name = "comp_name")
	@NotNull(message = "Campany name can't be null")
	@ApiModelProperty(value = "Gives company name, can't be null")
	private String compName;
	
	@ApiModelProperty(value = "Gives the location of the company")
	private String location;
	
	@Column(name = "num_of_employyes")
	@ApiModelProperty(value = "Returns the number of employees")
	@Size(min = 2, message = "Company should have minimum 2 employees")
	private int numOfEmployees;
	
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Employee> employee = new ArrayList<Employee>();

	public Company() {
		super();
	}

	public Company(String compName, String location, int numOfEmployees) {
		super();
		this.compName = compName;
		this.location = location;
		this.numOfEmployees = numOfEmployees;
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumOfEmployees() {
		return numOfEmployees;
	}

	public void setNumOfEmployees(int numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Company [compId=" + compId + ", compName=" + compName + ", location=" + location + ", numOfEmployees="
				+ numOfEmployees + "]";
	}	
	
}

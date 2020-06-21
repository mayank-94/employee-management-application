package com.spring.cloud.employeesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Pan Entity")
public class Pan {
	
	@Id
	@GeneratedValue
	@Column(name = "pan_id")
	@ApiModelProperty(value = "pan_id, Primary Key of Pan")
	private int panId;
	
	@Column(name = "pan_number", unique = true)
	@ApiModelProperty(value = "panNumber, A Unique Pan Number")
	private String panNumber;
	
	@NotNull(message = "Address can't be null")
	@ApiModelProperty(value = "address, Address of Pan Holder, can't be null")
	private String address;

	public Pan() {
		super();
	}

	public Pan(String panNumber, String address) {
		super();
		this.panNumber = panNumber;
		this.address = address;
	}

	public int getPanId() {
		return panId;
	}

	public void setPanId(int panId) {
		this.panId = panId;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Pan [panId=" + panId + ", panNumber=" + panNumber + ", address=" + address + "]";
	}	
}

package com.revolut.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@Column(name = "passport_number", nullable = false)
	private Long passportNumber;

	@Column(name = "name")
	private String name;

	public Long getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(Long passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

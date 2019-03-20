package com.revolut.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operation_type")
public class OperationType {

	 @GeneratedValue
	 @Id
	 @Column(name = "id_operation")
	 private Integer id;
	 
	 @Column(name = "operation_name", nullable = false, length = 45)
	 private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	 
	
}
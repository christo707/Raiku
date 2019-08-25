package com.raiku.curiosity.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="designation")
	@NotNull
	private String designation;
	

	public Employee() {
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + "]";
	}

	public Employee(String name, String desgination) {
		
		this.name = name;
		this.designation = desgination;
	}

	public Employee(int id, String name, String desgination) {
		super();
		this.id = id;
		this.name = name;
		this.designation = desgination;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
	
	
}

package com.etm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String employeeName;
	@Column(unique =true,nullable = false)
	private String email;
	private String password;
	@Column(length =10)
	private long phoneNumber;
	private double salary;
	private String role;
	
	@OneToMany
	private List<Task> tasks;
	
	
	
}

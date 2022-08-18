package com.personalProject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name="User")
@Table(name="USERS")
@Data
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public Long id;
	
	@Column(name="USER_NAME", length=50, nullable=false, unique=true)
	private String username;
	
	@Column(name="LAST_NAME", length=50, nullable=false)
	private String lastanme;
	
	@Column(name="FIRST_NAME", length=50, nullable=false)
	private String firstanme;
	
	@Column(name="EMAIL", length=50, nullable=false)
	private String email;
	
	@Column(name="ROLE", length=50, nullable=false)
	private String role;
	
	@Column(name="SSN", length=50, nullable=false, unique=true)
	private String ssn;
}

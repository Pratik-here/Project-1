package com.personalProject.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long orderId;
	
	@NotEmpty(message="Order Description should not be empty")
	@Column(name="FIRST_NAME", length=50, nullable=false)
	private String orderDescription;
}

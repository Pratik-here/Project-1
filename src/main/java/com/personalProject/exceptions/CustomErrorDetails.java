package com.personalProject.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

//Create simple custom error details bean
@Data
@AllArgsConstructor
public class CustomErrorDetails {

	private Date timestamp;
	private String message;
	private String errorDetails;
}

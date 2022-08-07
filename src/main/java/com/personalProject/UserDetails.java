package com.personalProject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDetails {
	private String lastName;
	private String firstName;
	private String city;
	@Override
	public String toString() {
		return "UserDetails [lastName=" + lastName + ", firstName=" + firstName + ", city=" + city + "]";
	}
	
	
}

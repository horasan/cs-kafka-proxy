package com.horasan.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer {
	
	private int id;
	
	private String firstName;
	private String lastName;
	private int dateOfBirth;
	
	public Customer(int id, String firstName, String lastName, int dateOfBirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
}
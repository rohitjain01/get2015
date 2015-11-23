package com.metacube.model;


import lombok.Data;

/**
 * Model class employee
 *
 */
@Data // to generate getters and setters automatically
public class Employee {
	private int id;
	private String name;
	private String email;
	private String Address;
}

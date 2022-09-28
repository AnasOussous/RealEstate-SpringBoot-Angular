package com.RealEstate_BackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {

	public Admin() {
		super();
	}

	public Admin(String name, String telephone, String email, String username, String password) {
		super(name, telephone, email, username, password);
	}

	
	
}

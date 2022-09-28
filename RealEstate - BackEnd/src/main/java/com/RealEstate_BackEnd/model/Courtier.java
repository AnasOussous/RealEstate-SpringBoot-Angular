package com.RealEstate_BackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "courtier")
public class Courtier extends User {

	public Courtier() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Courtier(String name, String telephone, String email, String username, String password) {
		super(name, telephone, email, username, password);
		// TODO Auto-generated constructor stub
	}
	
}

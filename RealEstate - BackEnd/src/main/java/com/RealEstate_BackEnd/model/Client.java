package com.RealEstate_BackEnd.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends User{

	public Client() {
		super();
	}

	public Client(String name, String telephone, String email, String username, String password) {
		super(name, telephone, email, username, password);
	}

	
	
	
}

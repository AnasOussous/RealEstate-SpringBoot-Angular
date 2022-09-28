package com.RealEstate_BackEnd.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "categories")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class, 
//        property = "id")
public class Categorie {
	@Id
	@Column(name = "Id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String nom;
	
	@OneToMany(mappedBy = "categories",cascade = CascadeType.ALL)
	private Set<Listing> listings;
    
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	

	public Set<Listing> getListings() {
		return listings;
	}

	public void setListings(Set<Listing> listings) {
		this.listings = listings;
	}

	public Categorie() {
		super();
	}
	
	
}

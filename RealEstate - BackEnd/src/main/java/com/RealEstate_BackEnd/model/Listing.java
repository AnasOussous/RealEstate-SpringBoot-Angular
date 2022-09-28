package com.RealEstate_BackEnd.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "listings")
public class Listing {

	@Id
	@Column(name = "Id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

    private String Name;
    @Column(name = "Description", length = 2000)
    private String Description;
    private Integer Price;
    private String City;
    private Integer Beds;
    private Integer Baths;
    private Integer m2;
    private Boolean SellOrRent;
    


 // Current Date
 	@Temporal(TemporalType.TIMESTAMP)
 	@Column(nullable = false)
 	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;
 	
 	@PrePersist
	private void onCreate() {
 		dateCreated = new Date();
	}

//	@ManyToOne(targetEntity = Categorie.class)
//	@JoinColumn(name = "categories_Id")
//	private Categorie categories;

	@ManyToOne(targetEntity = Categorie.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "categories_Id", insertable = false, updatable = false)
	@JsonIgnore
	private Categorie categories;

	@Column(name = "categories_Id")
	private Integer categorieId;
	
//	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinTable(name = "listing_images", 
//				joinColumns = @JoinColumn(name = "listing_id"),
//				inverseJoinColumns = @JoinColumn(name = "image_id"))
//	private Set<ImageModel> listingImages;
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		Description = description;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

	public String getCity() {
		return City;
	}




	public void setCity(String city) {
		City = city;
	}

	public Integer getBeds() {
		return Beds;
	}

	public void setBeds(Integer beds) {
		Beds = beds;
	}

//	public Set<ImageModel> getListingImages() {
//		return listingImages;
//	}
//
//
//
//
//	public void setListingImages(Set<ImageModel> listingImages) {
//		this.listingImages = listingImages;
//	}




	public Integer getBaths() {
		return Baths;
	}

	public void setBaths(Integer baths) {
		Baths = baths;
	}

	
	




	public Integer getM2() {
		return m2;
	}

	public void setM2(Integer m2) {
		this.m2 = m2;
	}

	public Boolean getSellOrRent() {
		return SellOrRent;
	}

	public void setSellOrRent(Boolean sellOrRent) {
		SellOrRent = sellOrRent;
	}


	public Date getDateCreated() {
		return dateCreated;
	}




	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Categorie getCategories() {
		return categories;
	}

	public void setCategories(Categorie categories) {
		this.categories = categories;
	}

	public Listing() {
		super();
		// TODO Auto-generated constructor stub
	}

}

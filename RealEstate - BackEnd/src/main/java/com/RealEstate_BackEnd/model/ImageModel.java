//package com.RealEstate_BackEnd.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "image_model")
//public class ImageModel {
//
//	@Id
//	@Column(name = "Id", columnDefinition = "serial")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long Id;
//	private String Name;
//    private String Type;
//    @Column(name = "pic", length = 1000)
//	private byte[] pic;
//    
//    
//    
//	public ImageModel() {
//		
//	}
//	public ImageModel(String name, String type, byte[] pic) {
//		super();
//		Name = name;
//		Type = type;
//		this.pic = pic;
//	}
//	public Long getId() {
//		return Id;
//	}
//	public void setId(Long id) {
//		Id = id;
//	}
//	public String getName() {
//		return Name;
//	}
//	public void setName(String name) {
//		Name = name;
//	}
//	public String getType() {
//		return Type;
//	}
//	public void setType(String type) {
//		Type = type;
//	}
//	public byte[] getPic() {
//		return pic;
//	}
//	public void setPic(byte[] pic) {
//		this.pic = pic;
//	}
//	
//	
//    
//    
//}

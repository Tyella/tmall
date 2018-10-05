package com.tmall.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
@Table(name="propertyvalue")
public class PropertyValue {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="pid")
	private Product product;
	@ManyToOne
	@JoinColumn(name="ptid")
	private Property property;
	private String value;
	
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setProduct(Product product) {
		this.product=product;
	}
	public Product getProduct() {
		return product;
	}
	public void setProperty(Property property) {
		this.property=property;
	}
	public Property getProperty() {
		return property;
	}
	public void setVaule(String value) {
		this.value=value;
	}
	public String getVaule() {
		return value;
	}
	

}

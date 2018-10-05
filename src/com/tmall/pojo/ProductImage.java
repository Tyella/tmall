package com.tmall.pojo;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
@Table(name="productimage")
public class ProductImage {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@JoinColumn(name="cid")
	@ManyToOne
	private Product product;
	private String type;
	
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
	public void setType(String type) {
		this.type=type;
	}
	public String getType() {
		return type;
	}

}

package com.tmall.pojo;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import javax.persistence.ManyToOne;

@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private Category category;
	private String name;
	private String subTitle;
	private int stock;                  //库存
	private Date createDate;            //创建日期
	private float originalPrice;        //原先的价格
	private float promotePrice;         //促销价格
	
	@Transient                          //Transient标记表示这个字段是瞬时字段，不会被注入数据库中
	private ProductImage productImage;  //产品图片
	
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setCategory(Category category) {
		this.category=category;
	}
	public Category getCategory() {
		return category;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle=subTitle;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setStock(int stock) {
		this.stock=stock;
	}
	public int getStock() {
		return stock;
	}
	public void setCreateDate(Date createDate) {
		this.createDate=createDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setOriginalPrice(float originalPrice) {
		this.originalPrice=originalPrice;
	}
	public float getOriginalPrice() {
		return originalPrice;
	}
	public void setPromotePrice(float promotePrice) {
		this.promotePrice=promotePrice;
	}
	public float getPromotePrice() {
		return promotePrice;
	}
	public void setProductImage(ProductImage productImage) {
		this.productImage=productImage;
	}
	public ProductImage getProductImage() {
		return productImage;
	}
	
}

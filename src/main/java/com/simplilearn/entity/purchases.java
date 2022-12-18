package com.simplilearn.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class purchases {

	@Id
	private int id;
	private String product_name;
	private String category;
	private String price;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public purchases(int id, String product_name, String category, String price,Date date) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.category = category;
		this.price = price;
		this.date = date;
	}
	public purchases() {
		
	}
}

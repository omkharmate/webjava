package com.assignment.entity;
/*
 * 
 * | product_id | product_name              | category_id | price    | stock | description                          |
 */
public class Product {
	private int product_id;
	private String product_name;
	private int categoryId;
	private double price;
	private int stock;
	private String description;
	
	
	public Product(int product_id, String product_name, int categoryId, double price, int stock, String description) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.categoryId = categoryId;
		this.price = price;
		this.stock = stock;
		this.description = description;
	}
	public int getProduct_id() {
		return product_id;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", categoryId=" + categoryId
				+ ", price=" + price + ", stock=" + stock + ", description=" + description + "]";
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	 
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	 
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Product() {
		super();
	}
	 
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	 
	
	
	
}

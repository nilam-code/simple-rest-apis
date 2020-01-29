package com.example.simplerestapis.models;

import java.util.Date;

public class ProductCompanyDTO {
	
	private String productName;
	
	private int orderNumber;
	
	private int quantity;
	
	private Date orderDate;
	
	private double salePrice;
	
	private double totalPrice;
	
	public ProductCompanyDTO(String productName, int orderNumber, int quantity, Date orderDate,
			double salePrice, double totalPrice) {
		super();
		this.productName = productName;
		this.orderNumber = orderNumber;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.salePrice = salePrice;
		this.totalPrice = totalPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
}

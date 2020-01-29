package com.example.simplerestapis.models;

import java.util.Date;

public class CompMonthSale {
    private String company;
    private Integer year;
    private Integer month;
    private double quantity;
    private String currency;
    private Date orderDate;

    
    public CompMonthSale(String company, Integer year, Integer month, Date orderDate,double quantity, String currency) {
		super();
		this.company = company;
		this.year = year;
		this.month = month;
		this.quantity = quantity;
		this.currency = currency;
		this.orderDate = orderDate;
	}

	public CompMonthSale(String company, int year, int month, double quantity, String currency) {
        super();
        this.company = company;
        this.year = year;
        this.month = month;
        this.quantity = quantity;
        this.currency = currency;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}

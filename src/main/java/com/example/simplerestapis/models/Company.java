package com.example.simplerestapis.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Company", schema="SALESDATA")
public class Company {
    @Id
    private String companyId;
    private String companyName;
    private Long prodId;
    private String productName;
    private String description;
    private double price;
    private String currency;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id")
    private Sale sale;

    
    public Company(String companyId, Long prodId, String productName,String description, double price, String currency) {
		super();
		this.companyId = companyId;
		this.prodId = prodId;
		this.description = description;
		this.price = price;
		this.currency = currency;
		this.productName = productName;
	}

	public Company() {
		
	}

	public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	

}

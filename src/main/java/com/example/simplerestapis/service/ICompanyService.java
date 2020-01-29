package com.example.simplerestapis.service;

import java.util.List;

import com.example.simplerestapis.models.Company;

public interface ICompanyService{
	
	public List<Company> retrieveCompanies();

	public Company getCompany(Long companyId);
	

}

package com.example.simplerestapis.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simplerestapis.models.Company;
import com.example.simplerestapis.repository.CompanyRepository;
import com.example.simplerestapis.service.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService{

	@Autowired
	 private CompanyRepository companyRepository;

	 public void setProductRepository(CompanyRepository companyRepository) {
	  this.companyRepository = companyRepository;
	 }
	 
	 @Override
	 public List<Company> retrieveCompanies() {
	  List<Company> companies = companyRepository.findAll();
	  return companies;
	 }
	 
	 @Override
	 public Company getCompany(Long companyId) {
	  Optional<Company> optEmp = companyRepository.findById(companyId);
	  return optEmp.get();
	 }
	 
	/* @Override
	 public Long getCompanyIdByName(String companyName)
	 {
		 Long companyId = companyRepository.getCompanyIdByName(companyName);
		 return companyId;
	 }*/
	 
	 public void saveCompany(Company company){
		 companyRepository.save(company);
		 }

}

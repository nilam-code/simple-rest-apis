package com.example.simplerestapis.service;

import java.util.List;

import com.example.simplerestapis.models.ProductCompanyDTO;

public interface ISalesService {
	public List<ProductCompanyDTO> salesDataByCompany(String companyId);
}

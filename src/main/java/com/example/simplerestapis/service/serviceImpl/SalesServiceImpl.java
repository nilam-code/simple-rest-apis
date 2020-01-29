package com.example.simplerestapis.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simplerestapis.models.CompMonthSale;
import com.example.simplerestapis.models.Company;
import com.example.simplerestapis.models.ProductCompanyDTO;
import com.example.simplerestapis.models.Sale;
import  com.example.simplerestapis.repository.CompanyRepository;
import com.example.simplerestapis.repository.SalesRepository;
import com.example.simplerestapis.service.ISalesService;

@Service
public class SalesServiceImpl implements ISalesService {

	@Autowired
	private SalesRepository salesRepository;
	@Autowired
	CompanyRepository companyRepo;

	

	public void setProductRepository(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}

	@Override
	public List<ProductCompanyDTO> salesDataByCompany(String companyId) {
		double totalPrice = 0.0;
		List<ProductCompanyDTO> salesData = salesRepository.salesDataByCompany(companyId);
		for (ProductCompanyDTO productCompanyDTO : salesData) {
			totalPrice += productCompanyDTO.getSalePrice();
			productCompanyDTO.setTotalPrice(totalPrice);
		}
		return salesData;
	}

	public List<CompMonthSale> getCompanySalesByMonth() {
		return salesRepository.findByCompanyMonthSales();
	}

	public List<CompMonthSale> getCompanyNetProfit() {
		return salesRepository.findByCompanyNetProfit();
	}

	public void saveSalesData(Sale sale) {
		salesRepository.save(sale);
	}

		
	
	/*public List<RevenueDTO> getRevenueReport(Long companyId) {
		List<RevenueDTO> revenueData = salesRepository.getRevenueReport(companyId);
		String month = null;
		double yearSales = 0.0;
		for (RevenueDTO revenueDTO : revenueData) {
			month = revenueDTO.getOrderDate().substring(2, 4);
			revenueDTO.setMonth(month);
			yearSales += revenueDTO.getMonthSales();
			revenueDTO.setYearSales(yearSales);
		}
		return revenueData;
	}

	public List<ProfitDTO> getProfitReport(Long companyId, Long id) {
		List<ProfitDTO> profitData = salesRepository.getProfitReport(companyId, id);
		String month = null;
		double yearlyProfit = 0.0;
		for (ProfitDTO profitDTO : profitData) {
			month = profitDTO.getOrderDate().substring(2, 4);
			profitDTO.setMonth(month);
			yearlyProfit += profitDTO.getNetProfit();
			profitDTO.setYearlyProfit(yearlyProfit);
		}
		return profitData;
	}
*/
}

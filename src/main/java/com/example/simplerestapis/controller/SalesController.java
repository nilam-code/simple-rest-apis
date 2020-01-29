package com.example.simplerestapis.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplerestapis.models.CompMonthSale;
import com.example.simplerestapis.models.ProductCompanyDTO;
import com.example.simplerestapis.service.serviceImpl.CompanyServiceImpl;
import com.example.simplerestapis.service.serviceImpl.SalesServiceImpl;

@RestController
public class SalesController {
	
	 @Autowired
	 private SalesServiceImpl salesService;
	 
	 @Autowired 
	 private CompanyServiceImpl companyService; 

	public void setSalesService(SalesServiceImpl salesService) {
		this.salesService = salesService;
	}
	
	public void setCompanyService(CompanyServiceImpl companyService) {
		this.companyService = companyService;
	}
	
	 
	 @GetMapping("/companies/{companyId}/sales")
	 public List<ProductCompanyDTO> getSalesData(@PathParam("companyId") String companyId) {
		 System.out.println("companyId: "+companyId);
		// Long companyId = companyService.getCompanyIdByName(companyName);
	  List<ProductCompanyDTO> salesData = salesService.salesDataByCompany(companyId);
	  System.out.println("salesData:" +salesData);
	  return salesData;
	 }
	 
	 @GetMapping("/companies/{companyId}/revenuereport")
	 public ResponseEntity<List<CompMonthSale>> getSalesByCompany(@PathParam("companyId") Long companyId) {
	        List<CompMonthSale> sales = salesService.getCompanySalesByMonth();
	        HttpStatus status = HttpStatus.NO_CONTENT;
	        if (sales == null) {
	            status = HttpStatus.NOT_FOUND;
	        } else {
	            status = HttpStatus.OK;
	        }
	        return new ResponseEntity<List<CompMonthSale>>(sales, status);
	    }
	 /*public List<RevenueDTO> getRevenuesReport(@PathParam("companyId") Long companyId) {
		 System.out.println("companyId: "+companyId);
		// Long companyId = companyService.getCompanyIdByName(companyName);
	  List<RevenueDTO> revenueData = salesService.getRevenueReport(companyId);
	  System.out.println("salesData:" +revenueData);
	  return revenueData;
	 }*/
	 
	 @GetMapping("/companies/{companyId}/profitreport")
	 public ResponseEntity<List<CompMonthSale>> getNetProfitByCompany(@PathParam("companyId") Long companyId) {
	        List<CompMonthSale> sales = salesService.getCompanyNetProfit();
	        HttpStatus status = HttpStatus.NO_CONTENT;
	        if (sales == null) {
	            status = HttpStatus.NOT_FOUND;
	        } else {
	            status = HttpStatus.OK;
	        }
	        return new ResponseEntity<List<CompMonthSale>>(sales, status);
	    }

	/* public List<ProfitDTO> getProfitReport(@PathParam("companyId") Long companyId, Long id) {
		 System.out.println("companyId: "+companyId);
		// Long companyId = companyService.getCompanyIdByName(companyName);
	  List<ProfitDTO> profitData = salesService.getProfitReport(companyId, id);
	  System.out.println("salesData:" +profitData);
	  return profitData;
	 }*/

}

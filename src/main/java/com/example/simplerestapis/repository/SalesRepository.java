package com.example.simplerestapis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.simplerestapis.models.CompMonthSale;
import com.example.simplerestapis.models.ProductCompanyDTO;
import com.example.simplerestapis.models.Sale;

@Repository
public interface SalesRepository extends JpaRepository<Sale, Long>{
	
	@Query("select new com.example.simplerestapis.models.ProductCompanyDTO(c.productName as ProductName,s.orderNumber, s.quantity, s.orderDate, s.salePrice, SUM(s.salePrice) as TotalPrice) from Company c, Sale s where c.companyId = ?1")
	public List<ProductCompanyDTO> salesDataByCompany(@Param("companyId") String companyId);

	/*@Query("select new com.example.simplerestapis.models.RevenueDTO(p.companyId, s.orderDate, s.salePrice as monthSales) from Product p, Sales s where p.companyId = ?1")
	public List<RevenueDTO> getRevenueReport(Long companyId);

	@Query("select new com.example.simplerestapis.models.ProfitDTO(p.companyId, p.id, s.orderDate, s.salePrice, p.price) from Product p, Sales s where p.companyId = ?1 and p.id = ?2")
	public List<ProfitDTO> getProfitReport(Long companyId, Long id);*/
	
	 @Query("SELECT new com.example.simplerestapis.models.CompMonthSale (c.companyName, extract(year from s.orderDate) as yr, extract(month from s.orderDate) as mon, s.orderDate,SUM(s.salePrice), s.currency )"
	            + " FROM Sale s, Company c GROUP BY c.companyName, extract(year from s.orderDate), extract(month from s.orderDate)")
	    List<CompMonthSale> findByCompanyMonthSales();
	 

	    @Query("SELECT new com.example.simplerestapis.models.CompMonthSale (c.companyName, extract(year from s.orderDate) as yr, extract(month from s.orderDate) as mon, s.orderDate, SUM(s.salePrice), s.currency )"
	            + " FROM Sale s, Company c GROUP BY c.companyName, extract(year from s.orderDate), extract(month from s.orderDate)")
	    List<CompMonthSale> findByCompanyNetProfit();

}

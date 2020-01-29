package com.example.simplerestapis.csvreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplerestapis.models.Company;
import com.example.simplerestapis.models.Sale;
import com.example.simplerestapis.service.serviceImpl.CompanyServiceImpl;
import com.example.simplerestapis.service.serviceImpl.SalesServiceImpl;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@RestController
public class InsertCsvData {

	@Autowired
	private CompanyServiceImpl companyService;

	@Autowired
	private SalesServiceImpl salesService;

	public static void main(String[] args) {
		//readSalesFile();
	}

	@PostMapping("/companies/company")
	public void saveCompany(Company company) {
		companyService.saveCompany(company);
		System.out.println("Company Saved Successfully");
	}

	@PostMapping("/companies/sales")
	public void saveSales(Sale sale) {
		salesService.saveSalesData(sale);
		System.out.println("Sales Saved Successfully");
	}

	public  void readSalesFile() {
		String path = "src/main/resources/salesfile/Sales.csv";
		File file = new File(path);
		List<Sale> salesList = new ArrayList<>();
		FileReader filereader;
		try {
			filereader = new FileReader(file);
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				Sale saleData = new Sale();
				if(nextRecord[1] != null && !nextRecord[1].isEmpty())
					saleData.setOrderDate(convertUtilToSql(formatter.parse(nextRecord[1])));
				if(nextRecord[2] != null && !nextRecord[2].isEmpty())
					saleData.setOrderNumber(Integer.parseInt(nextRecord[2]));
				if(nextRecord[3] != null && !nextRecord[3].isEmpty())
					saleData.setProdId(Long.parseLong(nextRecord[3]));
				if(nextRecord[4] != null && !nextRecord[4].isEmpty())
					saleData.setQuantity(Integer.parseInt(nextRecord[4]));
				if(nextRecord[5] != null && !nextRecord[5].isEmpty())
					saleData.setSalePrice(Double.parseDouble(nextRecord[5]));
				if(nextRecord[6] != null && !nextRecord[6].isEmpty())
					saleData.setCurrency(nextRecord[6]);

				System.out.println("saleData:" + saleData);
				//salesService.saveSalesData(saleData);
				System.out.println("Sales Saved Successfully");
			}
				System.out.println("list--" + salesList.size());
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			StringWriter stack = new StringWriter();
			e.printStackTrace(new PrintWriter(stack));

		} finally {
			// scanner.close();
		}
	}
	
	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}

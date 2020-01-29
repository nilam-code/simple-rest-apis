package com.example.simplerestapis.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.simplerestapis.models.Sale;
import com.example.simplerestapis.service.serviceImpl.SalesServiceImpl;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@RestController
public class FileUploadRestController {

	@Autowired
	private SalesServiceImpl salesService;
	private static final Logger logger = Logger.getLogger(FileUploadRestController.class.getName());

	@PostMapping("/companies/salesDataUpload")
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
		if (file == null) {
			throw new RuntimeException("You must select the a file for uploading");
		}
		
		sendCSVFile(file);
		InputStream inputStream = file.getInputStream();
		String originalName = file.getOriginalFilename();
		String name = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();
		logger.info("inputStream: " + inputStream);
		logger.info("originalName: " + originalName);
		logger.info("name: " + name);
		logger.info("contentType: " + contentType);
		logger.info("size: " + size);
		// Do processing with uploaded file data in Service layer
		return new ResponseEntity<String>(originalName, HttpStatus.OK);
	}

	private void sendCSVFile(MultipartFile file) {
		List<Sale> salesList = new ArrayList<>();
		Reader filereader;
		try {
			filereader = new InputStreamReader(file.getInputStream());
			String[] csvHeaders = getCSVHeaders(filereader);
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				for (String string : csvHeaders) {
				Sale saleData = new Sale();
				
				 if(string.equals("Order date"))
				 {
					 if (nextRecord[1] != null && !nextRecord[1].isEmpty())
						 saleData.setOrderDate(convertUtilToSql(formatter.parse(nextRecord[1])));
				 }
				 if(string.equals("Order number"))
				 {
					 if (nextRecord[2] != null && !nextRecord[2].isEmpty())
						 saleData.setOrderNumber(Integer.parseInt(nextRecord[2]));
				 }
				 if(string.equals("Product Id"))
				 {
					 if (nextRecord[3] != null && !nextRecord[3].isEmpty())
						 saleData.setProdId(Long.parseLong(nextRecord[3]));
				 }
				 if(string.equals("Quantity"))
				 {
					 if (nextRecord[4] != null && !nextRecord[4].isEmpty())
						 saleData.setQuantity(Integer.parseInt(nextRecord[4]));
				 }
				 if(string.equals("Sale price"))
				 {
					 if (nextRecord[5] != null && !nextRecord[5].isEmpty())
						 saleData.setSalePrice(Double.parseDouble(nextRecord[5]));
				 }
				 if(string.equals("Currency"))
				 {
					 if (nextRecord[6] != null && !nextRecord[6].isEmpty())
						 saleData.setCurrency(nextRecord[6]);
				 }

				System.out.println("saleData:" + saleData);
				salesService.saveSalesData(saleData);
				}
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

	private String[] getCSVHeaders(Reader filereader) {
		@SuppressWarnings("resource")
		CSVReader csvReader = new CSVReader(filereader);
		String[] header = null;
		try {
			 header = csvReader.readNext();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return header;
	}

	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}

}

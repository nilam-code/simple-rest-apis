# simple-rest-apis
There is batch file inside target folder which will execute and run the jar also there is docker file.

After starting and running the application execute Restapi urls  in POSTMAN 

sales data uploading functionality is completed. Company data csv uploading is half done so Insert scripts need to execute for company.
there are four services below are the url of the same.

1)POST : http://localhost:8080/companies/salesDataUpload file csv file as parameter to upload and save sales data.           
2)GET : http://localhost:8080/companies/sales/?companyId=1 company Id as parameter. TO see all the sales by company.           
3)GET : http://localhost:8080/companies/1/revenuereport/?companyId=1 company Id as parameter to check company revenue report.        
4)GET : http://localhost:8080/companies/1/profitreport/?companyId=1 companyId as parameter to see comapny profit report.   


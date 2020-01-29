package com.example.simplerestapis.csvreader;

public enum HeaderEnum {
	
	PRODUCTID("Product Id"), ID("Id"), PRODID("Prod. Id"),NAME("Name"),PRODUCT("Product"),DESCRIPTION("Description"),BUILDCOST("Build cost"),
	PURCHASE("Purchase"), ASSEMBLY("Assembly"),CURRENCY("Currency");

	
	private String headerName;
	private HeaderEnum(String headerName) 
    { 
        this.headerName = headerName; 
    }
	public String getHeaderName() {
		return headerName;
	}
	
}

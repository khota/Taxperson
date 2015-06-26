package com.taxperson.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class TaxCalculator {
	
	public int getItemType(String inputItem, int priceOftheItem) throws IOException{
		
		String value = "";
		String key = "";
		
		File file = new File("item.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInput);
		fileInput.close();
		
		Enumeration enuKeys = properties.keys();
		while (enuKeys.hasMoreElements()) {
			key = (String) enuKeys.nextElement();
			value = properties.getProperty(key);
		} 
		
		if (value == "BASIC"){
			
			priceOftheItem = priceOftheItem + priceOftheItem * 1/100;
		}
		
		else{
			
			priceOftheItem = priceOftheItem + priceOftheItem * 9/100;
		}
		
		return priceOftheItem;
			
	}
	
}

package org.nextgen.ecomm.services;

import java.util.HashMap;
import java.util.Map;

import org.nextgen.ecomm.model.Product;

public class DynaDataBaseService {

	
	private static Map<String, Product> productMap = new HashMap<String, Product>();
	
	
	public static Map<String, Product> getProductMap() {
		
		return productMap;
		
	}
}

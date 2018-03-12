package org.nextgen.ecomm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.nextgen.ecomm.model.Product;

public class ProductService {

	private static Map<String, Product> productMap = DataBaseService.getProductMap();

	public List<Product> getAllProducts() {

		return new ArrayList<Product>(productMap.values());
	}

	public Product getProduct(String productId) {

		return productMap.get(productId);
	}
}

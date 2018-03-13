package org.nextgen.ecomm.tools;

public class ProductTools {

	public double fetchskuPrice(String skuId, String productId) {

		if("sku001".equals(skuId)) {
			return 499.00;
		}
		
		if("sku002".equals(skuId)) {
			return 999.00;
		}
		
		if("sku003".equals(skuId)) {
			return 166.00;
		}
		
		
		return 0.0;
	}

	public String fetchskuName(String skuId) {
		
		if("sku001".equals(skuId)) {
			return "Apple iPhone 6";
		}
		
		if("sku002".equals(skuId)) {
			return "Apple iPhone X";
		}
		
		if("sku003".equals(skuId)) {
			return "Moto G5";
		}
		return null;
	}

}

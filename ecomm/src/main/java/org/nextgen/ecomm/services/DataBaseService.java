package org.nextgen.ecomm.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nextgen.ecomm.model.Cart;
import org.nextgen.ecomm.model.Product;
import org.nextgen.ecomm.model.Sku;

public class DataBaseService {

	
	private static Map<String, Product> productMap = new HashMap<String, Product>();
	private static Map<Long,Cart> cartMap= new HashMap<Long, Cart>();
	
	private static Map<String, String> tokenCartMap= new HashMap<String, String>();
	
	public static Map<String, Product> getProductMap() {
		
		//Sample Iphone 6s Product
		Sku iphone6SBlack32GBSku=new Sku("sku001", "apple Iphone 6s Black 32 GB","apple Iphone 6s Black 32 GB Descrption",true,499.00,99);
		Sku iphone6SBlack64GBSku=new Sku("sku002", "apple Iphone 6s Black 64 GB","apple Iphone 6s Black 64 GB Descrption",true,599.00,99);
		Sku iphone6SGold64GBSku=new Sku("sku003", "apple Iphone 6s Gold 64 GB","apple Iphone 6s Gold 64 GB Descrption",true,599.00,99);
		
		List<Sku> iphone6sSkuList=new ArrayList<Sku>();
		iphone6sSkuList.add(iphone6SBlack32GBSku);
		iphone6sSkuList.add(iphone6SBlack64GBSku);
		iphone6sSkuList.add(iphone6SGold64GBSku);
		Product appleIphone6Sproduct= new Product("prod001", "apple Iphone 6s", "apple Iphone 6s Description", true,iphone6sSkuList);
		productMap.put("prod001", appleIphone6Sproduct);
		
		//Sample Iphone X product
		Sku iphoneXBlack32GBSku=new Sku("sku004", "apple Iphone X Black 32 GB","apple Iphone X Black 32 GB Descrption",true,999.00,99);
		Sku iphoneXBlack64GBSku=new Sku("sku005", "apple Iphone X Black 64 GB","apple Iphone X Black 64 GB Descrption",true,999.00,99);
		Sku iphoneXGold64GBSku=new Sku("sku006", "apple Iphone X Gold 64 GB","apple Iphone X Gold 64 GB Descrption",true,999.00,99);
		
		List<Sku> iphoneXSkuList=new ArrayList<Sku>();
		iphoneXSkuList.add(iphoneXBlack32GBSku);
		iphoneXSkuList.add(iphoneXBlack64GBSku);
		iphoneXSkuList.add(iphoneXGold64GBSku);
		Product appleIphoneXproduct= new Product("prod002", "apple Iphone X", "apple Iphone X Description", true,iphoneXSkuList);
		productMap.put("prod002", appleIphoneXproduct);
		
		
		return productMap;
		
	}
	public static Map<Long, Cart> getCart() {
		return cartMap;
	}
	
	public static Map<String,String> getTokenCartMap(){
		return tokenCartMap;
		
	}
}

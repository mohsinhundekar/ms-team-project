package org.nextgen.ecomm.invetoryn;

import org.nextgen.ecomm.cart.AddToCartRequest;
import org.nextgen.ecomm.product.Product;
import org.nextgen.ecomm.product.ProductRepository;
import org.nextgen.ecomm.sku.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
	
	@Autowired
	private ProductRepository productRepository;

	public boolean isInventoryAvailable(AddToCartRequest addToCartRequest) {

		long quantityAvailableInHand=quantityAvailableInHand(addToCartRequest);
		
		return quantityAvailableInHand>0;
	}

	private long quantityAvailableInHand(AddToCartRequest addToCartRequest) {
		Product product = productRepository.findOne(addToCartRequest.getProductId());

		if(product != null) {
			for (Sku sku : product.getChildSkus()) {
				if (addToCartRequest.getSkuId().equals(sku.getSkuId())) {
					return sku.getSkuQtyAvailable();
				}
			}
		}
		
		return 0;
	}

	public void updateInventory(String skuId, String productId, long qty) {
		Product product = productRepository.findOne(productId);
		
		for (Sku sku : product.getChildSkus()) {
			if (skuId.equals(sku.getSkuId())) {
				long currentQtyAvailable=sku.getSkuQtyAvailable();
				sku.setSkuQtyAvailable(currentQtyAvailable-qty);
			}
		}
		productRepository.save(product);
		
	}


}

package org.nextgen.ecomm.tools;

import org.nextgen.ecomm.product.Product;
import org.nextgen.ecomm.product.ProductRepository;
import org.nextgen.ecomm.sku.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTools {

	@Autowired
	ProductRepository productRepository;

	public double fetchskuPrice(String skuId, String productId) {

		Product product = productRepository.findOne(productId);

		for (Sku sku : product.getChildSkus()) {
			if (skuId.equals(sku.getSkuId())) {
				return sku.getSkuPrice();
			}
		}

		return 0.0;
	}

	public String fetchskuName(String skuId, String productId) {

		Product product = productRepository.findOne(productId);

		for (Sku sku : product.getChildSkus()) {
			if (skuId.equals(sku.getSkuId())) {
				return sku.getSkuDescription();
			}
		}

		return null;
	}

}

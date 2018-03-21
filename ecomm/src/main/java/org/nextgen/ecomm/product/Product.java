package org.nextgen.ecomm.product;

import java.util.List;

import org.nextgen.ecomm.sku.Sku;
import org.springframework.data.annotation.Id;

public class Product {
	
	@Id
	private String id;

	private String productName;

	private String productDescription;

	private boolean isActive;
	
	public String getProductId() {
		return id;
	}

	public void setProductId(String productId) {
		this.id = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Sku> getChildSkus() {
		return childSkus;
	}

	public void setChildSkus(List<Sku> childSkus) {
		this.childSkus = childSkus;
	}

	private List<Sku> childSkus;
	
}

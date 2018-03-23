package org.nextgen.ecomm.product;

import java.util.List;

import org.nextgen.ecomm.sku.Sku;
import org.springframework.data.annotation.Id;

public class Product {
	
	@Id
	private String productId;

	private String productName;

	private String productDescription;

	private boolean activeFlag;
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public List<Sku> getChildSkus() {
		return childSkus;
	}

	public void setChildSkus(List<Sku> childSkus) {
		this.childSkus = childSkus;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	private List<Sku> childSkus;
	
}

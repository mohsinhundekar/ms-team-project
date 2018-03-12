package org.nextgen.ecomm.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private String productId;

	private String productName;

	private String productDescription;

	private boolean activeFlag;
	
	private List<Sku> childSkus;

	public Product() {
		
	}
	
	public Product(String productId, String productName, String productDescription, boolean activeFlag,
			List<Sku> childSkus) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.activeFlag = activeFlag;
		this.childSkus = childSkus;
	}

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

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public List<Sku> getChildSkus() {
		return childSkus;
	}

	public void setChildSkus(List<Sku> childSkus) {
		this.childSkus = childSkus;
	}

	

}

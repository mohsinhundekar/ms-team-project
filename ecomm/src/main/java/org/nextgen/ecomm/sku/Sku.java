package org.nextgen.ecomm.sku;

public class Sku {

	private String skuId;

	private String skuName;

	private String skuDescription;

	private boolean activeFlag;

	private double skuPrice;

	private long skuQtyAvailable;

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getSkuDescription() {
		return skuDescription;
	}

	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public double getSkuPrice() {
		return skuPrice;
	}

	public void setSkuPrice(double skuPrice) {
		this.skuPrice = skuPrice;
	}

	public long getSkuQtyAvailable() {
		return skuQtyAvailable;
	}

	public void setSkuQtyAvailable(long skuQtyAvailable) {
		this.skuQtyAvailable = skuQtyAvailable;
	}
}

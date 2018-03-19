package org.nextgen.ecomm.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CartItem {

	private String cartItemId;
	private String cartItemName;
	private long cartItemQty;
	private double cartItemUnitPrice;
	private double cartItemSubTotal;

	public String getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}

	public String getCartItemName() {
		return cartItemName;
	}

	public void setCartItemName(String cartItemName) {
		this.cartItemName = cartItemName;
	}

	public long getCartItemQty() {
		return cartItemQty;
	}

	public void setCartItemQty(long cartItemQty) {
		this.cartItemQty = cartItemQty;
	}

	public double getCartItemUnitPrice() {
		return cartItemUnitPrice;
	}

	public void setCartItemUnitPrice(double cartItemUnitPrice) {
		this.cartItemUnitPrice = cartItemUnitPrice;
	}

	public double getCartItemSubTotal() {
		return cartItemSubTotal;
	}

	public void setCartItemSubTotal(double cartItemSubTotal) {
		this.cartItemSubTotal = cartItemSubTotal;
	}

}

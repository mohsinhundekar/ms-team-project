package org.nextgen.ecomm.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cart {

	private long cartId;
	private List<CartItem> cartItems;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(long cartId) {
		this.cartId = cartId;
		this.cartItems= new ArrayList<CartItem>();
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}

	private double cartTotal;
}

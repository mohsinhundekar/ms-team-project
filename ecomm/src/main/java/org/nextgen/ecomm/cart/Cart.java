package org.nextgen.ecomm.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Cart {

	@Id
	private String cartId;
	private List<CartItem> cartItems;
	private double cartTotal;
	
	public Cart() {
		
	}

	public Cart(String cartId) {
		this.cartId = cartId;
		this.cartItems= new ArrayList<CartItem>();
	}
	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
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

}

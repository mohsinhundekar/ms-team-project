package org.nextgen.ecomm.tools;

import org.nextgen.ecomm.cart.Cart;
import org.nextgen.ecomm.cart.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartTools {
	
	@Autowired
	private ProductTools productTools;

	public CartItem createCartItem(String skuId, String productId, long qty) {

		CartItem cartItem = new CartItem();
		cartItem.setCartItemId(skuId);
		cartItem.setCartItemQty(qty);

		double cartItemUnitPrice = productTools.fetchskuPrice(skuId, productId);

		cartItem.setCartItemName(productTools.fetchskuName(skuId,productId));

		cartItem.setCartItemUnitPrice(cartItemUnitPrice);

		cartItem.setCartItemSubTotal(cartItemUnitPrice * qty);

		return cartItem;
		
	}
	
	public double computeCartTotal(Cart cart) {

		double cartTotal = 0.0;
		for (CartItem cartItem : cart.getCartItems()) {
			cartTotal = cartTotal + cartItem.getCartItemSubTotal();
		}
		return cartTotal;
	}
	
	public boolean isItemAlreadyInCart(String skuId, Cart cart) {

		for (CartItem cartItem : cart.getCartItems()) {
			if (skuId.equalsIgnoreCase(cartItem.getCartItemId())) {
				return true;
			}
		}

		return false;
	}
	
	public CartItem updatateQuantity(Cart cart, String skuId,String productId , long qty) {
		for (CartItem cartItem : cart.getCartItems()) {
			if (skuId.equalsIgnoreCase(cartItem.getCartItemId())) {
				long existingCartItemQty=cartItem.getCartItemQty();
				cartItem.setCartItemQty(existingCartItemQty+qty);
				cartItem.setCartItemSubTotal(cartItem.getCartItemUnitPrice() * cartItem.getCartItemQty());
				return cartItem;
			}
		}
		
		return createCartItem(skuId,
				productId, qty);
	}
	
	

}

package org.nextgen.ecomm.tools;

import org.nextgen.ecomm.model.AddToCartRequest;
import org.nextgen.ecomm.model.Cart;
import org.nextgen.ecomm.model.CartItem;

public class CartTools {
	private ProductTools productTools = new ProductTools();

	public CartItem createCartItem(String skuId, String productId, long qty) {

		CartItem cartItem = new CartItem();
		cartItem.setCartItemId(skuId);
		cartItem.setCartItemQty(qty);

		double cartItemUnitPrice = productTools.fetchskuPrice(skuId, productId);

		cartItem.setCartItemName(productTools.fetchskuName(skuId));

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

	public CartItem updatateQuantity(Cart cart, AddToCartRequest addtoCartRequest) {
		for (CartItem cartItem : cart.getCartItems()) {
			if (addtoCartRequest.getSkuId().equalsIgnoreCase(cartItem.getCartItemId())) {
				long existingCartItemQty=cartItem.getCartItemQty();
				cartItem.setCartItemQty(existingCartItemQty+addtoCartRequest.getQty());
				cartItem.setCartItemSubTotal(cartItem.getCartItemUnitPrice() * cartItem.getCartItemQty());
				return cartItem;
			}
		}
		
		return createCartItem(addtoCartRequest.getSkuId(),
				addtoCartRequest.getProductId(), addtoCartRequest.getQty());
	}

	public boolean isItemAlreadyInCart(String skuId, Cart cart) {

		for (CartItem cartItem : cart.getCartItems()) {
			if (skuId.equalsIgnoreCase(cartItem.getCartItemId())) {
				return true;
			}
		}

		return false;
	}

	public Cart deleteItemFromCart(Cart cart, String cartItemId) {
		for (CartItem cartItem : cart.getCartItems()) {
			if (cartItemId.equalsIgnoreCase(cartItem.getCartItemId())) {
				cart.getCartItems().remove(cartItem);
				break;
			}
		}
		return cart;
		
	}

}

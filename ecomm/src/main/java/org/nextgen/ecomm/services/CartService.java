package org.nextgen.ecomm.services;

import java.util.Map;

import org.nextgen.ecomm.model.AddToCartRequest;
import org.nextgen.ecomm.model.Cart;
import org.nextgen.ecomm.model.CartItem;
import org.nextgen.ecomm.tools.CartTools;

public class CartService {

	private Map<Long, Cart> cartMap = DataBaseService.getCart();
	private CartTools cartTools = new CartTools();

	public Cart addItemToCart(long cartId, AddToCartRequest addtoCartRequest) {

		String skuId = addtoCartRequest.getSkuId();

		CartItem cartItem = null;
		
		if (cartTools.isItemAlreadyInCart(skuId, cartMap.get(cartId))) {
			cartItem= cartTools.updatateQuantity(cartMap.get(cartId),addtoCartRequest);
		} else {
			cartItem = cartTools.createCartItem(addtoCartRequest.getSkuId(),
					addtoCartRequest.getProductId(), addtoCartRequest.getQty());
			cartMap.get(cartId).getCartItems().add(cartItem);
		}


		cartMap.get(cartId).setCartTotal(
				cartTools.computeCartTotal(cartMap.get(cartId)));

		return cartMap.get(cartId);

	}

	public Cart getCart() {
		return cartMap.get(111L);
	}

	public Cart deleteCart() {

		Cart cart=cartMap.get(111L);
		cartMap.remove(111L);
		return cart;
	}

	public Cart deleteItemFromCart(String cartItemId) {

		if (cartTools.isItemAlreadyInCart(cartItemId, cartMap.get(111L))) {
			
			return cartTools.deleteItemFromCart(cartMap.get(111L),cartItemId);
		}
		return null;
	}
}

package org.nextgen.ecomm.services;

import java.util.Map;

import org.nextgen.ecomm.model.AddToCartRequest;
import org.nextgen.ecomm.model.Cart;
import org.nextgen.ecomm.model.CartItem;
import org.nextgen.ecomm.tools.CartTools;

public class CartService {

	private static Map<Long, Cart> cartMap = DataBaseService.getCart();
	private CartTools cartTools = new CartTools();

	public Cart addItemToCart(AddToCartRequest addtoCartRequest) {

		String skuId = addtoCartRequest.getSkuId();

		CartItem cartItem = null;
		
		//Create a new cart if cart doesn't exist
		if(cartMap.size()==0) {
			cartMap.put(111L, new Cart(111L));
		}

		if (cartTools.isItemAlreadyInCart(skuId, cartMap.get(111L))) {
			cartItem= cartTools.updatateQuantity(cartMap.get(111L),addtoCartRequest);
		} else {
			cartItem = cartTools.createCartItem(addtoCartRequest.getSkuId(),
					addtoCartRequest.getProductId(), addtoCartRequest.getQty());
			cartMap.get(111L).getCartItems().add(cartItem);
		}


		cartMap.get(111L).setCartTotal(
				cartTools.computeCartTotal(cartMap.get(111L)));

		return cartMap.get(111L);

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

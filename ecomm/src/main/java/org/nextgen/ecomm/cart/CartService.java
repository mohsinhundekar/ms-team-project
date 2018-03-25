package org.nextgen.ecomm.cart;

import org.nextgen.ecomm.invetory.InventoryService;
import org.nextgen.ecomm.tools.CartTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private CartTools cartTools;

	public Cart getCart(String cartId) {

		return cartRepository.findOne(cartId);
	}

	public Cart addItemToCart(String skuId, String productId, long qty, String cartId) {
		
		Cart cart=cartRepository.findOne(cartId);
		
		//create a new cart with this Id
		if(cart== null) {
			cart=new Cart(cartId);
		}
		CartItem cartItem=null;
		if (cartTools.isItemAlreadyInCart(skuId, cart)) {
			cartItem= cartTools.updatateQuantity(cart, skuId,productId, qty);
		}
		else {
			cartItem = cartTools.createCartItem(skuId,
					productId, qty);
			cart.getCartItems().add(cartItem);
		}
		
		cart.setCartTotal(cartTools.computeCartTotal(cart));
		
		cartRepository.save(cart);
		inventoryService.updateInventory(skuId,productId,qty);
		

		return cartRepository.findOne(cartId);
	}

	public Cart deleteCart(String cartId) {
		
		cartRepository.delete(cartId);
		return null;
	}

	public Cart deleteItemFromCart(String cartItemId) {
		// TODO Auto-generated method stub
		return null;
	}

}

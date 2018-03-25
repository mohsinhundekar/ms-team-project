package org.nextgen.ecomm.cart;

import org.nextgen.ecomm.exception.InventoryNotAvailableException;
import org.nextgen.ecomm.invetory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value="/{cartId}",method = RequestMethod.GET)
	public Cart getCart(@PathVariable String cartId) {
		return cartService.getCart(cartId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Cart addItemToCart(@RequestBody AddToCartRequest addToCartRequest) {

		 if (inventoryService.isInventoryAvailable(addToCartRequest)) {
			 return cartService.addItemToCart(addToCartRequest.getSkuId(), addToCartRequest.getProductId(), addToCartRequest.getQty(), addToCartRequest.getCartId());
		 }
		 throw new InventoryNotAvailableException("inventory is not available for product: "+addToCartRequest.getProductId()+"sku: "+addToCartRequest.getSkuId());
	}

	@RequestMapping(value="/{cartId}",method = RequestMethod.DELETE)
	public Cart deleteCart(@PathVariable String cartId) {
		return cartService.deleteCart(cartId);
	}

	@RequestMapping(value = "{/cartItemId}", method = RequestMethod.DELETE)
	public Cart deleteItemFromCart(@PathVariable String cartItemId) {
		return cartService.deleteItemFromCart(cartItemId);
	}

}

package org.nextgen.ecomm.resource;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nextgen.ecomm.model.AddToCartRequest;
import org.nextgen.ecomm.model.Cart;
import org.nextgen.ecomm.services.CartService;
import org.nextgen.ecomm.utils.ValidationUtil;

@Path("cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {

	private CartService cartService = new CartService();

	@GET
	public Cart getCart() {
		return cartService.getCart();
	}

	@POST
	public Cart addItemToCart(AddToCartRequest addtoCartRequest) {

		if (ValidationUtil.isValidCartParameters()) {
			return cartService.addItemToCart(addtoCartRequest);
		}
		return null;
	}
	
	@DELETE
	public Cart deleteCart() {
		return cartService.deleteCart();
	}
	
	@DELETE
	@Path("/{cartItemId}")
	public Cart deleteItemFromCart(@PathParam("cartItemId") String cartItemId) {
		return cartService.deleteItemFromCart(cartItemId);
	}

}

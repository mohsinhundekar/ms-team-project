package org.nextgen.ecomm.resource;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.nextgen.ecomm.model.AddToCartRequest;
import org.nextgen.ecomm.model.Cart;
import org.nextgen.ecomm.services.CartService;
import org.nextgen.ecomm.utils.ValidationUtil;

@Path("cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {

	private CartService cartService = new CartService();
	
	
	@PermitAll
	@GET
	public Cart getCart() {
		
		
		return cartService.getCart();
	}
	
	@PermitAll
	@POST
	public Cart addItemToCart(AddToCartRequest addtoCartRequest, @HeaderParam("cartId") String cartId) {

		if (ValidationUtil.isValidCartParameters()) {
			return cartService.addItemToCart(Long.parseLong(cartId),addtoCartRequest);
		}
		return null;
	}
	
	@PermitAll
	@DELETE
	public Cart deleteCart() {
		return cartService.deleteCart();
	}
	
	@PermitAll
	@DELETE
	@Path("/{cartItemId}")
	public Cart deleteItemFromCart(@PathParam("cartItemId") String cartItemId) {
		return cartService.deleteItemFromCart(cartItemId);
	}

}

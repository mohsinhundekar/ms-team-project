package org.nextgen.ecomm.statemanagement;

import java.io.IOException;
import java.util.Map;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import org.nextgen.ecomm.model.Cart;
import org.nextgen.ecomm.services.DataBaseService;

public class CartManagementFilter implements ContainerRequestFilter{
	
	private static Long cartId =111L;
	
	private  Map<String, String> tokenCartMap = DataBaseService.getTokenCartMap();
	
	private  Map<Long, Cart> cartMap = DataBaseService.getCart();

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		Cookie tokenCookie = requestContext.getCookies().get("token");
		
		//TO-DO use this to check if the cookie was issued by the server (server should have alocal copy of this)
		boolean cookieIssuedByPool=isCookieIssuedByCookiePool(tokenCookie);
		
		
		if(tokenCookie== null) {
			
			//create a new cart 
			Long cartId= createNewCartForthisRequest();
			
			requestContext.getHeaders().add("cartId", cartId.toString());
			
		} else {
			requestContext.getHeaders().add("cartId", tokenCartMap.get(tokenCookie.getValue()));
		}
	}
	
	private Long createNewCartForthisRequest() {
		 cartId= cartId +1;
		 cartMap.put(cartId, new Cart(cartId));
		return cartId;
	}

	
	private boolean isCookieIssuedByCookiePool(Cookie tokenCookie) {
		return true;
	}
}

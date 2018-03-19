package org.nextgen.ecomm.statemanagement;

import java.io.IOException;
import java.util.Map;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.NewCookie;

import org.nextgen.ecomm.pools.CookiePool;
import org.nextgen.ecomm.services.DataBaseService;

public class CookieManagementFilter implements ContainerResponseFilter  {
	
	@Context
    private ResourceInfo resourceInfo;
	
	private CookiePool cookiePool=new CookiePool();
	
	private Map<String, NewCookie> cookiesAvailableinPool=CookiePool.getCookies();
	
	//This Map stores and keeps the token and cart Map 
	private  Map<String, String> tokenCartMap = DataBaseService.getTokenCartMap();

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		//Get the cart Id from the header
		String cartId=requestContext.getHeaders().get("cartId").get(0);
		 
		Cookie tokenCookie = requestContext.getCookies().get("token");
		
		if(tokenCookie== null) {
			NewCookie newCookie = cookiePool.getNewCookie();
			
			//Drop a new Cookie on the browser
			responseContext.getHeaders().add(HttpHeaders.SET_COOKIE, newCookie);
			
			cookiesAvailableinPool.put("tokenCookie", newCookie);
			
			tokenCartMap.put(newCookie.getValue(), cartId);
		}
	}
}

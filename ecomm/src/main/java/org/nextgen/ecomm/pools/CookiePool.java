package org.nextgen.ecomm.pools;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.NewCookie;

public class CookiePool {

	private static Integer token = 0;

	private static Map<String, NewCookie> cookieMap = new HashMap<String, NewCookie>();

	public NewCookie getNewCookie() {
		NewCookie newCookie = new NewCookie("token", generateNewToken());
		return newCookie;
	}

	private String generateNewToken() {
		token = token + 1;
		return "000" + token.toString() + "abc=";
	}

	public static Map<String, NewCookie> getCookies() {
		return cookieMap;
	}
}

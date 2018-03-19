package org.nextgen.ecomm;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.nextgen.ecomm.security.AuthenticationFilter;
import org.nextgen.ecomm.statemanagement.CartManagementFilter;
import org.nextgen.ecomm.statemanagement.CookieManagementFilter;
 

 
public class CustomApplication extends ResourceConfig
{
    public CustomApplication()
    {
        packages("org.nextgen.ecomm");
        register(LoggingFilter.class);
       // register(GsonMessageBodyHandler.class);
 
        //Register Auth Filter here
        register(AuthenticationFilter.class);
        register(CartManagementFilter.class);
        register(CookieManagementFilter.class);
        
    }
}

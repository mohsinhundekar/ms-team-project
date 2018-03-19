package org.nextgen.ecomm.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.nextgen.ecomm.model.Product;
import org.nextgen.ecomm.services.ProductService;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
	
	private ProductService productService = new ProductService();
	
	@PermitAll
	@GET
	public List<Product> getProducts(@QueryParam ("active") String activeFlag) {
		
		if(activeFlag !=null) {
			return productService.getProductsBasedOnActiveFlag(activeFlag);
		}
		return productService.getAllProducts();
	}
	
	@PermitAll
	@GET
	@Path("/{productId}")
	public Product getProduct(@PathParam( "productId")  String productId) {
		return productService.getProduct(productId);
	}
	
	@RolesAllowed("ADMIN")
	@POST
	public Product addProduct(Product product) {
		return productService.addProduct(product);
	}
	
	@RolesAllowed("ADMIN")
	@PUT
	@Path("/{productId}")
	public Product updateProduct(@PathParam("productId") String productId, Product product) {
		product.setProductId(productId);
		return productService.updateProduct(product);
	}
	
	@RolesAllowed("ADMIN")
	@DELETE
	@Path("/{productId}")
	public void deleteProduct(@PathParam("productId") String productId) {
		 productService.removeProduct(productId);
	}
	
	
	
	
}

package org.nextgen.ecomm;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nextgen.ecomm.model.Product;
import org.nextgen.ecomm.services.ProductService;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
	
	private ProductService productService = new ProductService();
	
	
	@GET
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	
	@GET
	@Path("{productId}")
	public Product getProduct(@PathParam( "productId")  String productId) {
		
		return productService.getProduct(productId);
	}
}

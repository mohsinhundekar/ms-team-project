package org.nextgen.ecomm;

import java.util.List;







import org.nextgen.ecomm.product.Product;
import org.nextgen.ecomm.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method=RequestMethod.GET)
	public List<Product> getProducts() {
			return productService.getAllProducts();
	}
	
	@RequestMapping(value="/{productId}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable String productId) {
		return productService.getProduct(productId);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@RequestMapping(value="/{productId}" ,method=RequestMethod.PUT)
	public Product updateProduct(@PathVariable String productId, @RequestBody Product product) {
		product.setProductId(productId);
		return productService.updateProduct(product);
	}
	
	
	@RequestMapping(value="/{productId}", method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable String productId) {
		 productService.removeProduct(productId);
	}
	
		
}

package org.nextgen.ecomm.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	public Product getProduct(String productId) {

		return productRepository.findOne(productId);
	}

	public Product addProduct(Product product) {

		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
		
	}

	public void removeProduct(String productId) {

		 productRepository.delete(productId);
	}

}

package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	public boolean addProduct(Product product);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getProductByName(String productName);
	public List<Product> getAllProducts();
	public List<Product> filterByPrice(int lowerPrice,int upperPrice);

	public boolean isProductExists(int productId);


}

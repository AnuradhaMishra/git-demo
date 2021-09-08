package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

// provide service class facility here 
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);		
		return true;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		return true;
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> productData = productRepository.findById(productId);
		Product product = productData.get();
		return product;
	}

	@Override
	public List<Product> getProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>)productRepository.findAll();
	}

	@Override
	public boolean isProductExists(int productId) {
		Optional<Product> productData = productRepository.findById(productId);
		return productData.isPresent();
	}

	@Override
	public List<Product> filterByPrice(int lowerPrice, int upperPrice) {
		// TODO Auto-generated method stub
		return productRepository.findByPriceBetween(lowerPrice,upperPrice);
	}
}

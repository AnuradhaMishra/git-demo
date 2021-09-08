package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {
	// Select * from freshproduct where productName=?
	public List<Product>findByProductName(String productName);
	
	// Select * from freshproduct where quantity=?

	//public List<Product>findByQuantityOnHand(String quantityOnHand);
	
	// Select * from freshproduct where quantity>?
	//public List<Product>findByQuantityOnHandGreater(String quantityOnHand);
	
	
	// Select * from freshproduct where quantity<?

	//public List<Product>findByQuantityOnHandLess(String quantityOnHand);
	
	// Select * from freshproduct where quantity is between int lowerPrice and int upperPrice ?

	public List<Product>findByPriceBetween(int lowerPrice,int upperPrice);






}
